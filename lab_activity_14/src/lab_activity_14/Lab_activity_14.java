/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package lab_activity_14;

/**
 *
 * @author Saba Fatima
 */

import java.util.HashMap;
import java.util.LinkedList;

class HTClass {
	
	  public static class HTObject<K,V> {
	        public Integer key;
	        public Integer value;
	    }
	 
	    public static final int ARR_SIZE = 128;// Separate Chaining
	    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];
	 
	    public HTClass() {
	        //init vals in array
	        for(int i=0; i<ARR_SIZE; i++) {
	            arr[i] = null;
	        }
	    }
	    
        public void display()
        {
        }
        	/*Iterator<HTObject> iterator=arr[0].iterator();
            while(iterator.hasNext()){
              System.out.println(iterator.next());
            }
            */
            
        
	    private HTObject getObj(Integer key) {
	        if(key == null)
	            return null;
	 
	        int index = key.hashCode() % ARR_SIZE;
	        LinkedList<HTObject> items = arr[index];
	 
	        if(items == null)
	            return null;
	 
	        for(HTObject item : items) {
	            if(item.key.equals(key))
	                return item;
	        }
	 
	        return null;
	    }
	 
	    public Integer get(Integer key) {
	        HTObject item = getObj(key);
	 
	        if(item == null)
	            return null;
	        else
	            return
	            item.value;
	    }
	 
	    
	    public void put(Integer key, Integer value) {
	        int index = key.hashCode() % ARR_SIZE;
	        LinkedList<HTObject> items = arr[index];
	 
	        if(items == null) {
	            items = new LinkedList<HTObject>();
	 
	            HTObject item = new HTObject();
	            item.key = key;
	            item.value = value;
	 
	            items.add(item);
	 
	            arr[index] = items;
	        }
	        else {
	            for(HTObject item : items) {
	                if(item.key.equals(key)) {
	                    item.value = value;
	                    return;
	                }
	            }
	 
	            HTObject item = new HTObject();
	            item.key = key;
	            item.value = value;
	 
	            items.add(item);
	        }
	    }
	 
	    public void delete(Integer key) {
	        int index = key.hashCode() % ARR_SIZE;
	        LinkedList<HTObject> items = arr[index];
	 
	        if(items == null)
	            return;
	 
	        for(HTObject item : items) {
	            if (item.key.equals(key)) {
	                items.remove(item);
	                return;
	            }
	        }
	    }
}
class LinearProbe {

	public static class HTObject {
        public String key;
        public Integer value;
    }
 
	// length dependent
	public int hashCode(String key) {
		   int hash = 0;
		   for (int i = 0; i < key.length() ; i++)
		      hash = (hash * 26) + key.charAt(i);
		   return hash;
		}
        public int hashCode1(String key){
            int hash=(11*(int)key.charAt(0))%ARR_SIZE;
            return hash;
        }
        public int hashCode2(String key){
            int hash=((int)key.charAt(0)%3)+1;
            return hash;
        }
	// Open Addressing collision is being resolved Linear Prob
    public static final int ARR_SIZE = 16;// Separate Chaining
    private HTObject[] arr = new HTObject[ARR_SIZE];
 
    public LinearProbe() {
        //init vals in array
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = null;
        }
    }
 
    public void put1(String key, Integer value) {
        int index = (hashCode(key)*11) % ARR_SIZE;
        HTObject item= new HTObject();   
        item.key=key;
        item.value=value;
        if (arr[index]==null)
        	arr[index]= item;
        else
        {
        	while(arr[index]!=null)
        		 {index++;
        		  index= index % ARR_SIZE ;}
        	arr[index]= item;
        }	
        }
    public void put2(String key,Integer value){
       int index=(hashCode(key)*11) % ARR_SIZE;
       HTObject item= new HTObject();   
        item.key=key;
        item.value=value;
        int i=1;
        if (arr[index]==null)
        	arr[index]= item;
        else
        {
             
        	while(arr[index]!=null){
                    index++;
                    index= (hashCode1(key)+i * hashCode2(key))%ARR_SIZE;
                    i++;
                }
        	arr[index]= item;
        }
    }
    public void display(){
        
        for(int i=0;i<16;i++){
            if(arr[i]==null)
                System.out.println("Index " + i + " ---> Null");
            else
            System.out.println("Index " + i + " ---> " + arr[i].key);
        }
    }
}
  class Hashing {

	 static void createHashMap(int arr[]) 
	    { 
	        // Creates an empty HashMap 
	        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 
	  
	        // Traverse through the given array 
	        for (int i = 0; i < arr.length; i++) { 
	  
	            // Get if the element is present 
	            Integer c = hmap.get(arr[i]); 
	  
	            // If this is first occurrence of element 
	            // Insert the element 
	            if (hmap.get(arr[i]) == null) { 
	                hmap.put(arr[i], 1);
	                
	            } 
	  
	            // If elements already exists in hash map 
	            // Increment the count of element by 1 
	            else { 
	                hmap.put(arr[i], ++c); 
	            } 
	        } 
	  
	        // Print HashMap 
	        System.out.println(hmap); 
	    } 
   
  }


public class Lab_activity_14 {

    public static void main(String[] args) {
        
        LinearProbe lp1 = new LinearProbe();
        LinearProbe lp2 = new LinearProbe();
        System.out.println("Q1: \n");
        lp1.put1("R",1);
        lp1.put1("E",2);
        lp1.put1("P",3);
        lp1.put1("U",4);
        lp1.put1("B",5);
        lp1.put1("L",6);
        lp1.put1("I",7);
        lp1.put1("C",8);
        lp1.put1("A",9);
        lp1.put1("N",10);
        lp1.display();
        System.out.println();
        System.out.println("Q2:\n");
        lp2.put2("A",1);
        lp2.put2("N",2);
        lp2.put2("O",3);
        lp2.put2("T",4);
        lp2.put2("H",5);
        lp2.put2("E",6);
        lp2.put2("R",7);
        lp2.put2("X",8);
        lp2.put2("M",9);
        lp2.put2("P",10);
        lp2.put2("L",11);
        lp2.display();
    }
    
}
