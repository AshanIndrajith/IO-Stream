package userInput.ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(7200);
            System.out.println("Server is running in port number 7200");
            Socket s=ss.accept();

            DataInputStream dataInputStream= new DataInputStream(s.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(s.getOutputStream());

            Scanner msg = new Scanner(System.in);
            while(true) {
                System.out.println("Server :");
                String text = msg.nextLine();

                dataOutputStream.writeUTF(text);
                dataOutputStream.flush();

                String rec=dataInputStream.readUTF();
                System.out.println("client"+rec);




            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
