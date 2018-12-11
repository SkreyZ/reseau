package Tp10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{

    ServerSocket serverSocket;
    Socket socket;
    Server server;

    public Client(ServerSocket serverSocket)throws IOException{
        this.serverSocket = serverSocket;
        this.socket = serverSocket.accept();
    }

    @Override
    public void run() {
        try {
            //Socket socket = serverSocket.accept();
            server.suscribeToBroadcast(this);
            server.BroadcastMessage("Connexion");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader((socket.getInputStream())));


            //Permet renvoyer les lignes lues par le client depuis la sortie standard.
            for (;;) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("[" + line + "]");
            }


            socket.close();
            serverSocket.close();
            server.BroadcastMessage("Deconnexion");
            server.unsuscribeToBroadast(this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) throws IOException {
        PrintWriter writer = new PrintWriter(
                socket.getOutputStream(), true);
        writer.print(msg);
    }
}
