package it.itsrizzoli;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App
{
    static int PortN=1234;
    public static void main( String[] args )
    {
        ServerSocket server=null;
        try {
            server=new ServerSocket(PortN);
            System.out.println("Server started!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket Client=null;
        while (true) {
            try {
                Client = server.accept();
                System.out.println("Client connected!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ClientHandler CH=new ClientHandler(Client);
            new Thread(CH).start();
        }
    }
}