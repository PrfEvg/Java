package Lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket = new ServerSocket(8191);
    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    public Server() throws IOException {}

    public void serverInitialize(){
        System.out.println("Клиент подключился.");
        Thread dataThread = new Thread(() -> {
            String msg;
            while (true){
               try {
                   msg = "Client: " + in.readUTF();
                   System.out.println(msg);
                   out.writeUTF(msg);
               } catch (IOException e){
                   e.printStackTrace();
               }
            }
        });
        dataThread.start();
        serverMsg();
    }
    public void serverMsg(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine() + '\n';
            try {
                out.writeUTF("Server: " + msg);
                System.out.println("Server: " + msg);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
