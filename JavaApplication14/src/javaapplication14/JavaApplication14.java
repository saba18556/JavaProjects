/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.Scanner;

/**
 *
 * @author Saba Fatima
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter String: ");
        
        String input = in.nextLine();
        
        StringBuffer display =new StringBuffer(input);
        
        for(int i=0; i<input.length(); i++){
            
            if(Character.isLowerCase(input.charAt(i)))
            {
                
                display.setCharAt(i, (char) (input.charAt(i)-32));
                
            }
            
            else if(Character.isUpperCase(input.charAt(i)))
            {
                
                display.setCharAt(i,(char) (input.charAt(i)+32));
                
            }
            
        }
        StringBuffer reverse = new StringBuffer(display);
        int j=1;
        for(int i=0;i<display.length(); i++){
            reverse.setCharAt(display.length()-j, display.charAt(i));
            j++;
        }
        System.out.println(reverse);
    }
    
}
