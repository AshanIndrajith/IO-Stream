package udp_programing;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {


        try {
            DatagramSocket serversocket=new DatagramSocket(5050);
            System.out.println("server started");

            byte[] receiveBuffer=new byte[1024];

            while(true){
                DatagramPacket datagramPacket= new DatagramPacket(receiveBuffer,receiveBuffer.length);
                serversocket.receive(datagramPacket);


                InetAddress clientaddress=datagramPacket.getAddress();
                int clientport=datagramPacket.getPort();

                String message=new String(datagramPacket.getData(),0,datagramPacket.getLength());
                System.out.println("Client says:"+message);

                String response="server received the message :"+message;
                byte[] responseBytes=response.getBytes();

                DatagramPacket responsePacket=new DatagramPacket(responseBytes,responseBytes.length,clientaddress,clientport);

                serversocket.send(responsePacket);

                if(message.equalsIgnoreCase("bye")){
                    break;
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
