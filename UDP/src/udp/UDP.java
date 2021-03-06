
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDP {

    public static void main(String[] args) throws IOException {
        
        try{
        //InetAddress ip = InetAddress.getByName("192.168.10.1");
        DatagramSocket ds = new DatagramSocket(null);
        InetSocketAddress socket = new InetSocketAddress("192.168.0.101", 32000);
        ds.bind(socket);
        
        byte[] server_receive = new byte[80];
        DatagramPacket dp_receive = new DatagramPacket(server_receive, server_receive.length);
        ds.receive(dp_receive);
        String client = new String(dp_receive.getData()/*,0, dp_receive.getLength()*/);
        System.out.println("Data recieved from client: " + client);
        
        StringBuffer display =new StringBuffer(client);
        
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
        StringBuffer reverse = new StringBuffer(display);
        int j=1;
        for(int i=0;i<display.length(); i++){
            reverse.setCharAt(display.length()-j, display.charAt(i));
            j++;
        }
        
        String s = reverse.toString();
        byte[] server_send = s.getBytes();
        //InetAddress add = InetAddress.getByName("20.0.0.1");
        DatagramPacket dp_send = new DatagramPacket(server_send, server_send.length, dp_receive.getAddress(), dp_receive.getPort()); 
        ds.send(dp_send);
        ds.close();
        }
        catch(SocketException e){
            e.printStackTrace();
        }
    }
    
}
