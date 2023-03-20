package org.example;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.example.ServerConfig.HOST;
import static org.example.ServerConfig.PORT;

public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println(reader.readLine());

            writer.println("Привет сервер!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

