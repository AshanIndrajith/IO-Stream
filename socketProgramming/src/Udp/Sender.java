package Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {

    public static void main(String[] args) {

        try {
            DatagramSocket ds=new DatagramSocket();
            String str="Welcome java";
            InetAddress ip= InetAddress.getByName("127.0.0.1");
            DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),ip,3000);
            ds.send(dp);
            ds.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
