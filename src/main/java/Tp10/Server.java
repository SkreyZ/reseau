package Tp10;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

   Client client;

   void run(){
       try{
           ServerSocket serverSocket = new ServerSocket(8088);

           Client client = new Client(serverSocket);

           //Lance le client dans un nouveau Thread.
           new Thread(client).start();
       } catch (IOException e){
           e.printStackTrace();
       }
   }

   void suscribeToBroadcast(Client client){
        this.client = client;
   }

   void unsuscribeToBroadast(Client client){
        this.client = null;
   }

   void BroadcastMessage(String message){
        System.out.println(message);
   }
}
