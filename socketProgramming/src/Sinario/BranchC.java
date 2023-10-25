package Sinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BranchC {


    private static final String SEVER_IP= "localhost";
    private static final int SEVER_PORT=5050;




    public static void main(String[] args) {


        try {
            Socket socket = new Socket(SEVER_IP,SEVER_PORT);
            System.out.println("Connect to server");
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);


            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter item code :");
            String itemcode=userInput.readLine();


            out.println(itemcode);
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

            // Close the streams and socket
            in.close();
            out.close();
            userInput.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
