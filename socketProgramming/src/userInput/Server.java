package userInput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket that listens on port 7020
            ServerSocket ss = new ServerSocket(7020);
            System.out.println("Server is running on port 7020");

            // Accept incoming connections from clients
            Socket clientSocket = ss.accept();

            // Create DataInputStream and DataOutputStream for communication
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Read user input on the server
                System.out.print("Server: ");
                String serverMessage = scanner.nextLine();

                // Send the server message to the client
                dos.writeUTF(serverMessage);
                dos.flush();

                // Read the message sent by the client
                String clientMessage = dis.readUTF();
                System.out.println("Client: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
