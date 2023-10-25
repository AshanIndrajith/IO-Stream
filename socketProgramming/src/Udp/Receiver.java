package Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

    public static void main(String[] args) {
        try {
            DatagramSocket ds=new DatagramSocket(3000);
            System.out.println("server is running");

            byte[] buf=new byte[1024];
            DatagramPacket dp=new DatagramPacket(buf,1024);
            ds.receive(dp);
            String str=new String(dp.getData(),0,dp.getLength());
            System.out.println(str);
            ds.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
