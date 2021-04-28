package Lesson6.server;

import java.io.IOException;


public class ServerApp {
    public static void main(String[] args) {
    Server server = null;
    try {
        System.out.println("Сервер запущен на порту: 8191. Ожидаем подключения клиента...");
        server = new Server();

    } catch (IOException e){
        e.printStackTrace();
    }
    if (server != null) {
        server.serverInitialize();
    }
    }
}
