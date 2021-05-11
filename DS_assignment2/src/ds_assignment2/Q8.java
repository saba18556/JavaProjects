/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_assignment2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Saba Fatima
 */
public class Q8 {
    
    int priority;
    int length;
    String name;
    
    Q8(String name, int length, int priority){
        this.priority = priority;
        this.length = length;
        this.name = name;
    }
    
    public static void execute(PriorityQueue pq){
        while(!pq.isEmpty()){
            Q8 task = (Q8) pq.poll();
        
        for(int i=0; i<task.length; i++){
            if(i==0){
            System.out.println(task.name + " is processing with " + task.priority +" as priority and length "+ task.length);
            }
            else{
                System.out.println("No new job this slice");
            }
        }
        }
    }
    
    public static void main(String[] args){
        PriorityQueue<Q8> queue = new PriorityQueue(new Comparator<Q8>() {
            @Override
            public int compare(Q8 o1, Q8 o2) {
               if(o1.priority>o2.priority){
                   return +1;
               }
               if(o1.priority==o2.priority){
                   return 0;
               }
               return -1;
            }
        });
        System.out.println("Q8:\n");
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        do{
            
            System.out.println("Enter name:");
            String name = "";
            name = in.next();
            int length = 0;
            int prior = 0;
            boolean p = false;
            do{
                 
                System.out.print("Enter priority:");
                prior = in.nextInt();
                if (prior >= 19 || prior <= -20) {
                    p = true;
                    System.out.println("You need to enter priority within -19 and 20");
                } else {
                    p = false;
                }

            } while (p);
            boolean l = false;
            do{
                System.out.print("Enter length: ");
                length = in.nextInt();
                if (length >= 100 || length <= 1) {
                    l = true;
                    System.out.println("You need to enter length within 1 and 100");
                } else {
                    l = false;
                }

            } while (l);

            queue.add(new Q8(name, length, prior));

            System.out.println("Do you want to schedule more tasks? y/n ");
            String c = in.next();
            if (c.equalsIgnoreCase("y")) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        
        System.out.println("");
        
        execute(queue);
            
            
        
        
    }
    
}
