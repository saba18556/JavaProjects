/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

/**
 *
 * @author Saba Fatima
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class Contributor{
    
    String name;
    Dictionary dictionary;
    Contributor(){
        
    }
    Contributor(String name, Dictionary skills){
        this.name = name;
        this.dictionary = skills;
    }
    public void print(){
        System.out.println(this.name);
        for (Enumeration k = this.dictionary.keys(), i = this.dictionary.elements(); k.hasMoreElements();)
        {
            System.out.println("Key: " + k.nextElement());
            System.out.println("Value: " + i.nextElement());
        }
   
            
            
        }
       
       
    }
    
    
    


class Project{
    String name;
    int days;
    int score;
    int best_before;
    Dictionary dictionary;
    Project(){
        
    }
    
    Project(String name, int days, int score, int best_before, Dictionary dictionary){
        this.name = name;
        this.days= days;
        this.score = score;
        this.best_before = best_before;
        this.dictionary = dictionary;
}
    public void print(){
        System.out.println(this.name);
       for (Enumeration i = this.dictionary.elements(); i.hasMoreElements();)
        {
            System.out.println("Value in Dictionary : " + i.nextElement());
            
        }
       for (Enumeration k = this.dictionary.keys(); k.hasMoreElements();)
        {
            System.out.println("Keys in Dictionary : " + k.nextElement());
        }
       
    }
}
public class JavaApplication31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try {
      File myObj = new File("a_an_example.in.txt");
      Scanner myReader = new Scanner(myObj);
      //String name;
      Dictionary dictionary;
      ArrayList<Contributor> contributor = new ArrayList<>();
      ArrayList<Project> project = new ArrayList<>();
      
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arrOfStr = data.split(" ");
        //System.out.println(arrOfStr[0] + arrOfStr[1]);
        
        for(int i=0; i<Integer.parseInt(arrOfStr[0]); i++){
            String data1 = myReader.nextLine();
            String[] arrOfStr1 = data1.split(" ");
            String name = arrOfStr1[0];
           dictionary = new Hashtable();
           
           for(int j=0; j<Integer.parseInt(arrOfStr1[1]); j++){
               String data2 = myReader.nextLine();
            String[] arrOfStr2 = data2.split(" ");
            dictionary.put(arrOfStr2[0], arrOfStr2[1]);
           }
           Contributor cont = new Contributor(name,dictionary);

           contributor.add(cont);
           cont.print();
           
           //System.out.println(arrOfStr1[0] + arrOfStr1[1]);
        }
        
        for(int i=0; i<Integer.parseInt(arrOfStr[1]); i++){
            String data1 = myReader.nextLine();
            String[] arrOfStr1 = data1.split(" ");
            String name = arrOfStr1[0];
            int days = Integer.parseInt(arrOfStr1[1]);
            int score = Integer.parseInt(arrOfStr1[2]);
            int best_before = Integer.parseInt(arrOfStr1[3]);
            Dictionary dictionary1 = new Hashtable();
            
            for(int j=0; j<Integer.parseInt(arrOfStr1[4]); j++){
                
                String data2 = myReader.nextLine();
                String[] arrOfStr2 = data2.split(" ");
                dictionary1.put(arrOfStr2[0], arrOfStr2[1]);
           }
            Project proj = new Project(name, days, score, best_before, dictionary1);
            project.add(proj);
            proj.print();
        }
      }
      
      
      //String[] array = new String[count]; 
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

        
    }
    
}
