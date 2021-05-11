
package javaapplication3;


public class JavaApplication3 {
    
   


 

 

 

public static int RepeatedElements(int[] arr) 

        { 

            if (arr.length > 1) 

            { 

                int[] Array = new int[arr.length - 1]; 

                for (int i = 1; i < arr.length; i++) 

                { 

                    if (arr[0] == arr[i]) 

                        return arr[0]; 

                    else 

                        Array[i - 1] = arr[i]; 

                } 

                return RepeatedElements(Array); 

            } 

  

            return 0; 

        }

    public static void main(String[] args) {
        int[] arr ={3,2,4,3};
        System.out.println(RepeatedElements(arr));
       
        
        
    }
    
}
