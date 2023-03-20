package org.example;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) {
            System.out.println("Сервер запущен");

            while (true) {

                try (Socket client = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Новое подключение клиента: " + client.getPort());

                    writer.println("Здравствуйте! Вы подключились к серверу! Порт: " + client.getPort());
                    System.out.println("Сообщение от клиента: " + reader.readLine());

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
