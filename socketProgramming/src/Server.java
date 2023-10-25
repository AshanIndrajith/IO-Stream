import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket that listens on port 7020
            ServerSocket ss = new ServerSocket(7020);
            System.out.println("Server is running on port 7020");

            // Accept incoming connections from clients
            Socket clientSocket = ss.accept();

            // Create a DataInputStream to receive data from the client
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            // Read the message sent by the client
            String clientMessage = dis.readUTF();
            System.out.println("Message received from the client: " + clientMessage);

            // Create a DataOutputStream to send a response to the client
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            // Send a response to the client
            String responseMessage = "Hello, Client!";
            dos.writeUTF(responseMessage);
            dos.flush();

            // Close the socket
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
