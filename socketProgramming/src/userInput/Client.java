package userInput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        try {
            // Create a socket and connect to the server on localhost at port 7020
            Socket serverSocket = new Socket("localhost", 7020);

            // Create DataInputStream and DataOutputStream for communication
            DataInputStream dis = new DataInputStream(serverSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(serverSocket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Read user input on the client
                System.out.print("Client: ");
                String clientMessage = scanner.nextLine();

                // Send the client message to the server
                dos.writeUTF(clientMessage);
                dos.flush();

                // Read the message sent by the server
                String serverMessage = dis.readUTF();
                System.out.println("Server: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
