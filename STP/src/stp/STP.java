package stp;

import java.util.ArrayList;
import java.util.Scanner;

class Switch{
    
    BPDU packet;
    int no_of_ports;
    int no_of_switches;
    boolean is_root;
    //ArrayList<Switch> topology;
    ArrayList<ports> my_ports;
    
    Switch(int ID, int no_of_ports){
        
        this.is_root = true;
        packet = new BPDU(ID);
        this.no_of_ports = no_of_ports;
        my_ports = new ArrayList<>();
        for(int i=0; i<no_of_ports;i++){
            my_ports.add(new ports());
        }
        
    }
    
    BPDU get_packet(){
        return packet;
    }
    
    public void transmit(){
        for(int i = 0; i< no_of_ports; i++){
        my_ports.get(i).sw.recieve(this.packet);
    }
    }
    
    public void recieve(BPDU packet){
       for(int i=0; i<no_of_ports; i++){
           if((packet.B_ID) == (my_ports.get(i).sw.get_packet().B_ID)){
               my_ports.get(i).incoming_packet = packet;
           }
       }
    }
    
    public void comparison(){
        
        boolean flag = false;
        int lowest_value = packet.root_ID;
        for(int i=0; i < no_of_ports; i++){
            if(my_ports.get(i).incoming_packet.root_ID < lowest_value){
                lowest_value = my_ports.get(i).sw.get_packet().root_ID;
                is_root = false;
                packet.root_ID = lowest_value;
                packet.cost = my_ports.get(i).sw.get_packet().cost + 19;
                flag = true;
            }
            else if((my_ports.get(i).incoming_packet.root_ID == lowest_value)&& my_ports.get(i).incoming_packet.cost + 19 < packet.cost){
                is_root = false;
                packet.root_ID = lowest_value;
                packet.cost = my_ports.get(i).sw.get_packet().cost + 19;
                flag = true;
            }
        }
        if(flag){
            transmit();
            for(int i=0; i<no_of_ports; i++){
                my_ports.get(i).sw.comparison();
            }
        }
        
    }
    
    public void root_election(){
        
        int lowest_cost = my_ports.get(0).incoming_packet.cost;
        
        ArrayList<ports> same_cost = new ArrayList<>();
        same_cost.add(my_ports.get(0));
        if(!is_root){
        for(int i=0; i<my_ports.size();i++){
            if(my_ports.get(i).incoming_packet.cost < lowest_cost){
                same_cost = new ArrayList<>();
                same_cost.add(my_ports.get(i));
            lowest_cost = my_ports.get(i).incoming_packet.cost;
            }
            else if(my_ports.get(i).incoming_packet.cost == lowest_cost && i >= 1){
                same_cost.add(my_ports.get(i));
            }
        }
        
        if(same_cost.size()>1){
            int lowest_bridgeID = same_cost.get(1).incoming_packet.B_ID;
            ports lowest_port = same_cost.get(1);
            for(int i=0; i<same_cost.size(); i++){
            if(same_cost.get(i).incoming_packet.B_ID < lowest_bridgeID){
                lowest_bridgeID = same_cost.get(i).incoming_packet.B_ID;
                lowest_port = same_cost.get(i);
                
            }
            }
            lowest_port.set_label("Root Port");
        }
        
        else{
           same_cost.get(0).set_label("Root Port"); 
        }
        }
        
    }
    
    public void designated_and_block(){
        if(!is_root){
            for(int i=0;i<my_ports.size();i++){
                if(my_ports.get(i).type == null){
                    if(packet.cost < my_ports.get(i).incoming_packet.cost){
                        my_ports.get(i).set_label("Designated port");
                    }
                    else if(packet.cost > my_ports.get(i).incoming_packet.cost){
                        my_ports.get(i).set_label("Block port");
                    }
                    else{
                        if(packet.B_ID < my_ports.get(i).incoming_packet.B_ID){
                            my_ports.get(i).set_label("Designated port");
                        }
                        else if(packet.B_ID > my_ports.get(i).incoming_packet.B_ID){
                            my_ports.get(i).set_label("Block port");
                        }
                    }
                }
                
            }
        }
        
        else{
            for(int i=0; i<my_ports.size();i++){
                    my_ports.get(i).set_label("Designated port");
                }
            }
        }
        
    }

public class STP {

    public static void main(String[] args) {
        
//        ArrayList<Switch> my_switches = new ArrayList<>();
//        
//        Switch sw1 = new Switch(100, 2);
//        Switch sw2 = new Switch(20, 3);
//        Switch sw3 = new Switch(15, 3);
//        Switch sw4 = new Switch(60, 2);
//        
//        my_switches.add(sw1);
//        my_switches.add(sw2);
//        my_switches.add(sw3);
//        
//        sw1.my_ports.get(0).set_connection(sw2);
//        sw1.my_ports.get(1).set_connection(sw3);
//        sw2.my_ports.get(0).set_connection(sw3);
//        sw2.my_ports.get(1).set_connection(sw1);
//        sw2.my_ports.get(2).set_connection(sw4);
//        sw3.my_ports.get(0).set_connection(sw1);
//        sw3.my_ports.get(1).set_connection(sw2);
//        sw3.my_ports.get(2).set_connection(sw4);
//        sw4.my_ports.get(0).set_connection(sw2);
//        sw4.my_ports.get(1).set_connection(sw3);
//        
//        sw1.transmit();
//        sw2.transmit();
//        sw3.transmit();
//        sw4.transmit();
//        
//        sw1.comparison();
//        sw2.comparison();
//        sw3.comparison();
//        sw4.comparison();
//        
//        sw1.root_election();
//        sw2.root_election();
//        sw3.root_election();
//        sw4.root_election();
//        
//        sw1.designated_and_block();
//        sw2.designated_and_block();
//        sw3.designated_and_block();
//        sw4.designated_and_block();
//        
//        System.out.println("Switch 1 " + sw1.packet.toString());
//        for(int i=0;i<2;i++){
//            System.out.println(sw1.my_ports.get(i).type);
//        }
//        System.out.println("Switch 2 " + sw2.packet.toString());
//        for(int i=0;i<3;i++){
//            System.out.println(sw2.my_ports.get(i).type);
//        }
//        System.out.println("Switch 3 " + sw3.packet.toString());
//        for(int i=0;i<3;i++){
//            System.out.println(sw3.my_ports.get(i).type);
//        }
//        System.out.println("Switch 4 " + sw4.packet.toString());
//        for(int i=0;i<2;i++){
//            System.out.println(sw4.my_ports.get(i).type);
//        }
          
          stp_run();
    }
    
    public static void stp_run(){
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("How many switches do you want to add to your Topology?\n--> ");
        int no_of_switches = in.nextInt();
        Switch switch_array[] = new Switch[no_of_switches];
        System.out.print("Add no of ports to your switches");
        for(int i = 0; i<switch_array.length; i++){
            System.out.print((i+1) +". switch\n--> ");
            int no_of_ports = in.nextInt();
            switch_array[i] = new Switch((i+1), no_of_ports);
        }
         
         while (true)
                {
                    System.out.println("\n1 - Make a Connection");
                    System.out.println("0 - Exit");
                    System.out.print("--> ");
                    int choice2 = in.nextInt();
                    if (choice2 == 1)
                    {
                        System.out.println("Select a number against the switch from the below list that u want to connect");
        for(int i = 0; i<switch_array.length; i++){
            System.out.println((i+1) + ". Switch " + (i+1));
        }
        System.out.print("-->");
        int switch_connect = in.nextInt();
        switch_connect -=1;
                        System.out.println("Choose Ports for Connection");
                        
                        System.out.println("Select the port from the below list from "+(switch_connect + 1)+ " to form connection");
        for(int i=0; i < switch_array[switch_connect].my_ports.size(); i++){
            if(switch_array[switch_connect].my_ports.get(i).is_connection()){
                System.out.println("Port "+(i+1) +" is connected");
                continue;
            }
            else{
                System.out.println("Following ports are available for connection");
                System.out.println((i+1) + ". Port " + (i+1));
            }
        }
        int port_connect =in.nextInt();
        port_connect -=1;
                        System.out.println("Now select a number against the switch from the below list that u want Switch"+ (switch_connect + 1) +" to connect with");
        for(int i = 0; i<switch_array.length; i++){
            if(i==switch_connect){
                continue;
            }
            else{
            System.out.println((i+1) + ". Switch " + (i+1));
            }
        }
        System.out.print("-->");
        int switch_connect_with = in.nextInt();
        switch_connect_with -= 1;
        
        System.out.println("Ports that are available from the below list for Switch "+(switch_connect_with+1)+" to connect with Port "+(port_connect+1));
        for(int i=0; i < switch_array[switch_connect_with].my_ports.size(); i++){
            if(switch_array[switch_connect_with].my_ports.get(i).is_connection()){
                System.out.println("Port "+(i+1) +" is connected");
                continue;
            }
            else{
                System.out.println("Following ports are available for connection");
                System.out.println("Port " + (i+1));
            }
        }
        System.out.print("-->");
        int port_connect_with =in.nextInt();
        port_connect_with -=1;
                        switch_array[switch_connect].my_ports.get(port_connect).set_connection(switch_array[switch_connect_with]);
         switch_array[switch_connect_with].my_ports.get(port_connect_with).set_connection(switch_array[switch_connect]);

                    }
                    else if (choice2 == 0)
                        break;
                    
                }
                System.out.println("\n--Turning Switches ON--");
                for (int i = 0; i < switch_array.length; i++)
                    switch_array[i].transmit();
                for (int i = 0; i < switch_array.length; i++)
                    switch_array[i].comparison();
                for (int i = 0; i < switch_array.length; i++)
                {
                    switch_array[i].root_election();
                    switch_array[i].designated_and_block();
                }
                
                for (int i = 0; i < switch_array.length; i++)
                {
                    System.out.println("Switch " + (i+1) + " BPDU is " + switch_array[i].packet);
                    for (int j = 0; j < switch_array[i].my_ports.size(); j++)
                    {
                        if (switch_array[i].my_ports.get(j).is_connection())
                            System.out.println("Switch " + (i + 1) + " Port " + (j + 1) + " Connected To " + switch_array[i].my_ports.get(j).sw.get_packet().B_ID + " Is Labeled As " + switch_array[i].my_ports.get(j).type);
                    }
                    System.out.println("");
                }
    }
    
}
