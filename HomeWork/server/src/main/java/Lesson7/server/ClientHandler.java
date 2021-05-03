package Lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket= socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.server = server;
        new Thread(() -> {
          try {
              //цикл авторизации
              while (true){
                  String msg = in.readUTF();
                  if(msg.startsWith("/login ")) {
                      String usernameFromLogin = msg.split("\\s")[1];
                      if(server.isUserOnline(usernameFromLogin)){
                          sendMessage("/login _failedCurrent nickname has already been occupied");
                          continue;
                      }
                      username = usernameFromLogin;
                      sendMessage("/login_ok " + username);
                      server.subscribe(this);
                      break;
                  }
              }
              //цикл общения с клиентом
              while (true){
                  String msg = in.readUTF();
                  if(msg.startsWith("/")){
                      executeCommand(msg);
                      continue;
                  }
                 else { server.broadcastMessage(username + ": " + msg);}
              }
          } catch (IOException e){
              e.printStackTrace();
          } finally {
              disconnect();
          }
        }).start();
    }
    private void executeCommand(String cmd) throws IOException {
        if(cmd.startsWith("/w ")) {
            String[] tokens = cmd.split("\\s", 3);
            server.sendPrivateMessage(this, tokens[1], tokens[2]);
            return;
        }
        if(cmd.startsWith("/end")){
            sendMessage("Вы отключились от сервера.");
            disconnect();
            return;
        }
        if (cmd.startsWith("/who_am_i")){
            sendMessage("You are: " + getUsername() + '\n');
        }
    }

    private void disconnect() {
        server.unsubscribe(this);
        if(in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }
    public String getUsername() {
        return username;
    }
}
