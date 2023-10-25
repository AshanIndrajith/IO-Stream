package Udp.messageBetween;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            System.out.println("Client is running");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String clientMessage = scanner.nextLine();
                byte[] sendData = clientMessage.getBytes();

                InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
                int serverPort = 3000;
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

                ds.send(sendPacket);

                // Create a DatagramPacket to receive the response from the server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                ds.receive(receivePacket);

                // Extract and print the response from the server
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + serverResponse);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
