//GROUP MEMBERS: Saba Fatima And Mahum Fatima Khan

package ccn_project;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;


public class client_java_udp {
    
    public static void main(String[] args) throws IOException{
     
        // Assign system's ip or localhost address
        System.out.println("csil-machine2> client "+ "192.168.0.101" + " " + 32000);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your message to be sent: ");
        String s = in.nextLine();
        
        // client socket creation
        DatagramSocket ds = new DatagramSocket();
        
        // buffer of client for sending data
        byte[] client_send = s.getBytes();
        
        // Server IP
        InetAddress add = InetAddress.getByName("192.168.0.101");
        
        // sending packet created
        DatagramPacket dp_send = new DatagramPacket(client_send,client_send.length,add, 32000);
        
        // sending message to server
        ds.send(dp_send);  
        
        // buffer of client for receiving data
        byte[] client_receive = new byte[80];
        
        // recieving packet created
        DatagramPacket dp_receive = new DatagramPacket(client_receive, client_receive.length);
        
        // received response from server
        ds.receive(dp_receive);
        
        // connection terminated
        ds.close();
     
        String display = new String(dp_receive.getData());
        System.out.println("Response from Server: "+ display) ;
     
    }   
}