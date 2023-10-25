package Udp.messageBetween;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(3000);
        System.out.println("Server is Running");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Create a DatagramPacket to receive data from the client
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            ds.receive(receivePacket);

            // Extract the received message from the client
            String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client: " + receiveMessage);

            // Read a response message from the server user
            System.out.print("Server: ");
            String responseMessage = scanner.nextLine();

            // Convert the response message to bytes
            byte[] responseData = responseMessage.getBytes();

            // Create a DatagramPacket to send the response back to the client
            DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length,
                    receivePacket.getAddress(), receivePacket.getPort());

            // Send the response to the client
            ds.send(sendPacket);

            // Create a DatagramPacket to receive the response from the client
            byte[] clientResponseData = new byte[1024];
            DatagramPacket clientResponsePacket = new DatagramPacket(clientResponseData, clientResponseData.length);

            ds.receive(clientResponsePacket);

            // Extract and print the response from the client
            String clientResponseMessage = new String(clientResponsePacket.getData(), 0, clientResponsePacket.getLength());
            System.out.println("Client Response: " + clientResponseMessage);


        }
    }
}
