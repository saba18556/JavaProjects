
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {

    public static void main(String[] args) throws Exception {
        
        DatagramSocket ds = new DatagramSocket(1000);
        byte[] server_receive = new byte[80];
        DatagramPacket dp_receive = new DatagramPacket(server_receive, server_receive.length);
        ds.receive(dp_receive);
        String display = new String(dp_receive.getData()/*,0, dp_receive.getLength()*/);
        System.out.println("Data recieved from client: " + display);
        
        String s = "hi";
        byte[] server_send = s.getBytes();
        InetAddress add = InetAddress.getLocalHost();
        DatagramPacket dp_send = new DatagramPacket(server_send, server_send.length, add, dp_receive.getPort()); 
        ds.send(dp_send);
    }
    
}
