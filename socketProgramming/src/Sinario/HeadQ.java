package Sinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HeadQ {

    private static final int PORT=5050;
    private static final Map<String,Double> priceMap=new HashMap<>();
    private static final Map<String,Double> discountMap=new HashMap<>();



    public static void main(String[] args){


        try {
            ServerSocket serverSocket=new ServerSocket(PORT);
            System.out.println("Headquarters server started and listening on port " + PORT);

            while(true){
                Socket clientSocket=serverSocket.accept();
                System.out.println("New client connected");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void populaterMap(){

        priceMap.put("MT001",2500.00);
        priceMap.put("MT002",1200.00);
        priceMap.put("HT003",350.00);

        discountMap.put("MT001", 5.0);
        discountMap.put("MT002", 2.5);
        discountMap.put("MT003", 0.0);


    }


    private static class ClientHandler extends Thread {

        private  final Socket clientSocket;


        private ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {

            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);

                String itemCode=in.readLine();
                Double initialPrice=priceMap.getOrDefault(itemCode,0.0);
                Double discount=discountMap.getOrDefault(itemCode,0.0);

                Double finalPrice=initialPrice*(1-discount/100);

                out.println("Item code"+itemCode);
                out.println("Initial Price: " + initialPrice);
                out.println("Discount: " + discount + "%");
                out.println("Final Price: " + finalPrice);

                in.close();
                out.close();
                clientSocket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }



}
