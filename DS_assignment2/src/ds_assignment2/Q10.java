/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_assignment2;

import java.util.ArrayList;
import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Comparator; 
/**
 *
 * @author Saba Fatima
 */
class HuffmanNode { 
  
    int data; 
    char c; 
  
    HuffmanNode left; 
    HuffmanNode right; 
} 
class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
        return x.data - y.data; 
    } 
} 
public class Q10 {
    
    public static void printCode(HuffmanNode root, String s) 
    {  
        if (root.left 
                == null
            && root.right 
                   == null
            && Character.isLetter(root.c)) { 
  
            System.out.println(root.c + ":" + s); 
  
            return; 
        } 
  
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
    }
    
    public static void main(String[] args) 
    { 
  
        System.out.println("Q10:\n");
  
         String s = "HelloWorld";
         char[] charArray = s.toCharArray();
        
        int n = charArray.length;
        int[] freq = new int[charArray.length];
        for(int i=0;i<charArray.length; i++){
            freq[i] = 1;
            for(int j=0;j<charArray.length;j++){
                freq[j]++;
            }
        }
        int[] charfreq = freq;
        PriorityQueue<HuffmanNode> q 
            = new PriorityQueue<HuffmanNode>(n, new MyComparator()); 
  
        for (int i = 0; i < n; i++) { 
   
            HuffmanNode hn = new HuffmanNode(); 
  
            hn.c = charArray[i]; 
            hn.data = charfreq[i]; 
  
            hn.left = null; 
            hn.right = null; 
  
            q.add(hn); 
        } 
  
         
        HuffmanNode root = null; 
  
        while (q.size() > 1) { 
  
            
            HuffmanNode x = q.peek(); 
            q.poll(); 
   
            HuffmanNode y = q.peek(); 
            q.poll(); 
  
            
            HuffmanNode f = new HuffmanNode(); 
   
            f.data = x.data + y.data; 
            f.c = '-'; 
  
            f.left = x; 
  
            f.right = y; 
   
            root = f; 
  
            q.add(f); 
        } 
  
        printCode(root, ""); 
    } 
} 
  

