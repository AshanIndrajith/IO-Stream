import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try {
            // Create a socket and connect to the server on localhost at port 7020
            Socket serverSocket = new Socket("localhost", 7020);

            // Create a DataOutputStream to send data to the server
            DataOutputStream dos = new DataOutputStream(serverSocket.getOutputStream());

            // Write the message "Hello Server" to the server
            String clientMessage = "Hello Server";
            dos.writeUTF(clientMessage);
            dos.flush();

            // Create a DataInputStream to receive a response from the server
            DataInputStream dis = new DataInputStream(serverSocket.getInputStream());

            // Read the response sent by the server
            String serverResponse = dis.readUTF();
            System.out.println("Response received from the server: " + serverResponse);

            // Close the socket
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
