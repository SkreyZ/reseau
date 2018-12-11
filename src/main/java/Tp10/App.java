package Tp10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App{
public static void main( String[] args )throws IOException{
        System.out.println("Hello World!");

        Server server = null;
        server.run();

        //ServerSocket serverSocket = new ServerSocket(8088);

        //Client client = new Client(serverSocket);

        //Lance le client dans un nouveau Thread.
        //new Thread(client).start();

        /*try {
            ServerSocket serverSocket = new ServerSocket(8088);

            Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader((socket.getInputStream())));
            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);

            //Permet renvoyer les lignes lues par le client depuis la sortie standard.
            for (; ; ) {
                String line = reader.readLine();
                if (line == null) break;
                writer.println("[" + line + "]");
            }

            socket.close();
            serverSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/
    }
}
