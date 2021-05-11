
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPclient {
    
    public static void main(String[] args) throws Exception{
    
     DatagramSocket ds = new DatagramSocket();
     String s = "n danmdababd,mndbfcmnedbb cjabdjbajbfsabjebfjefbmbfmbfmdjsmfbmdfmbbfmenfbmdbnbfmd";
     byte[] client_send = s.getBytes();
     InetAddress add = InetAddress.getLocalHost();
     DatagramPacket dp_send = new DatagramPacket(client_send,client_send.length,add, 1000);
     ds.send(dp_send);  
     
     byte[] client_receive = new byte[80];
     DatagramPacket dp_receive = new DatagramPacket(client_receive, client_receive.length);
     ds.receive(dp_receive);
     
     String display = new String(dp_receive.getData());
     System.out.println("Data received from server: " + display) ;
     
     
     
    }
}
