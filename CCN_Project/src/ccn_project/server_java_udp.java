//GROUP MEMBERS: Saba Fatima And Mahum Fatima Khan

package ccn_project;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class server_java_udp {

    public static void main(String[] args) throws IOException {
        
        try{
            
        // Assignment of port number and assign IP that of your system or localhost    
        int port =32000;
        DatagramSocket ds = new DatagramSocket(null);
        InetSocketAddress socket = new InetSocketAddress("192.168.0.101", port);
        System.out.println("csil-machine1> Server "+ port);
        ds.bind(socket);
        
        // buffer of Server for receiving data
        byte[] server_receive = new byte[80];
        
        // receiving packet created
        DatagramPacket dp_receive = new DatagramPacket(server_receive, server_receive.length);
        
        // recieved data from client
        ds.receive(dp_receive);
        
        String client = new String(dp_receive.getData());
        System.out.println("Data recieved from client: " + client);
        
        // Changes done by Server to client's data
        StringBuffer display =new StringBuffer(client);
        
        // changing letters from Uppercase to Lowercase and vice versa
        for(int i=0; i<client.length(); i++){
            
            if(Character.isLowerCase(client.charAt(i)))
            {
                
                display.setCharAt(i, (char) (client.charAt(i)-32));
                
            }
            
            else if(Character.isUpperCase(client.charAt(i)))
            {
                
                display.setCharAt(i,(char) (client.charAt(i)+32));
                
            }
            
        }
        
        // Reversing the String
        StringBuffer reverse = new StringBuffer(display);
        int j=1;
        for(int i=0;i<display.length(); i++){
            reverse.setCharAt(display.length()-j, display.charAt(i));
            j++;
        }
        
        String s = reverse.toString();
        byte[] server_send = s.getBytes();
        
        // sending packet created to client to response with received data
        DatagramPacket dp_send = new DatagramPacket(server_send, server_send.length, dp_receive.getAddress(), dp_receive.getPort());
        
        // packet sent
        ds.send(dp_send);
        
        // connection terminated
        ds.close();
        
        }
        catch(SocketException e){
            e.printStackTrace();
        }
    }
    
}
