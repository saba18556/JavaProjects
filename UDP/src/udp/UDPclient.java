
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPclient {
    
    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your message to be sent: ");
        String s = in.nextLine();
        
        DatagramSocket ds = new DatagramSocket();
        byte[] client_send = s.getBytes();
        InetAddress add = InetAddress.getByName("192.168.0.101");
        DatagramPacket dp_send = new DatagramPacket(client_send,client_send.length,add, 32000);
        ds.send(dp_send);  
     
        byte[] client_receive = new byte[80];
        DatagramPacket dp_receive = new DatagramPacket(client_receive, client_receive.length);
        ds.receive(dp_receive);
        ds.close();
     
        String display = new String(dp_receive.getData());
        System.out.println("Data received from server: " + display) ;
     
     
     
    }
}
