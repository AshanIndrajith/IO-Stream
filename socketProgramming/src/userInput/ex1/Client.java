package userInput.ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket serverSocket=new Socket("localhost",7200);

            DataOutputStream dos=new DataOutputStream(serverSocket.getOutputStream());
            DataInputStream dis=new DataInputStream(serverSocket.getInputStream());

            Scanner ss=new Scanner(System.in);

            while(true){

                System.out.println("Client :");
                String msg=ss.nextLine();

                dos.writeUTF(msg);

                String text= dis.readUTF();
                System.out.println("Server :"+text);


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
