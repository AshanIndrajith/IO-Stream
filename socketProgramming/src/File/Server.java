package File;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {


        try {
            ServerSocket serverSocket=new ServerSocket(5050);
            System.out.println("Server started");


            Socket clientSocket=serverSocket.accept();

            InputStream in=clientSocket.getInputStream();


            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("copy.txt"));

            byte[] buffer=new byte[1024];
            int bytesRead;

            while((bytesRead=in.read(buffer))!=-1){

                out.write(buffer,0,bytesRead);
            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
