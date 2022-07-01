package it.itsrizzoli;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    Socket Client;
    BufferedReader in;
    PrintWriter out;
    Result result=new Result();


    @Override
    public void run() {
        this.clientToClientHandler();
        this.clientHandlerToClient();
    }

    private void clientToClientHandler() {
        try {
            in=new BufferedReader(
                    new InputStreamReader(Client.getInputStream())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out=new PrintWriter(Client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clientHandlerToClient() {
        Gson gson=new Gson();
        String s;
        while (true){
            s=receive();
            try{
                switch (s) {
                    default:
                        Frase f1=new Frase(letterCounter(s),wordsCounter(s),replacerString(s));
                        result.AggiungiFrase(f1);
                        out.println(gson.toJson(result));
                        break;
                }
            }catch (NullPointerException e){
                System.out.println("Client disconnected!");
                break;
            }
            if (s=="") break;
        }
    }
    private int letterCounter(String s) {
        int n=0;
        for(int i=0;i<s.length();i++){
            n++;
        }
        return n;
    }
    private int wordsCounter(String s){
        int n=1;
        String spazio=" ";
        for(int i=0;i<s.length();i++){
            char l=s.charAt(i);
            if (l == ' ') {
                n++;
            }


        }
        return n;
        }

    private String replacerString(String s){
        s=s.replace(" ","-");
        return s;
    }

    String receive() {
        String s="";
        try {
            s=in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    ClientHandler(Socket client) {
        this.Client = client;
    }

}

