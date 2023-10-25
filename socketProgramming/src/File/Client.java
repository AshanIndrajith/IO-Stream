package File;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server
            Socket socket = new Socket("localhost", 5050);
            System.out.println("Connected to server...");

            // Create input stream to read the file data
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("original.txt"));

            // Create output stream to send the file data to the server
            OutputStream out = socket.getOutputStream();

            // Create a buffer to hold the file data
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read data from the file and send it to the server
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Flush the output stream to ensure all data is sent
            out.flush();

            // Close the streams and socket
            out.close();
            in.close();
            socket.close();

            System.out.println("File transfer completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}