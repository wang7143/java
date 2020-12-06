package Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


import org.junit.Test;

public class UDPtest {

    @Test
    public void sender() throws IOException {
        DatagramSocket da = new DatagramSocket();

        String str = "我是UDP";
        byte[] data = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket Packet = new DatagramPacket(data,0,data.length,localHost,9090);

        da.send(Packet);

        da.close();
    } 
    public static void main(String[] args) throws IOException {
        DatagramSocket data = new DatagramSocket(9090);
        byte[] buf = new byte[100];
        DatagramPacket Packet = new DatagramPacket(buf,0,buf.length);
        data.receive(Packet);
        System.out.println(new String(Packet.getData(),0,Packet.getLength()));
    }
}
