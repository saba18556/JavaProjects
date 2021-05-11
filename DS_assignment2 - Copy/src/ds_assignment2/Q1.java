/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_assignment2;

/**
 *
 * @author Saba Fatima
 */


public class Q1 {
    public static int[] sumRecursion(int[] arr, int sum, int start, int end) {
      int[] arr1 = new int[2];
    if (start == end){
        arr1[0] = -1;
        arr1[1] = -1;
        return arr1;
    }
        else if(arr[start] + arr[end] == sum) {
            arr1[0] = arr[start];
            arr1[1] = arr[end];
            return arr1;
        }
    if (arr[start] + arr[end] < sum){
            return sumRecursion(arr, sum, start + 1, end);
        }
        return sumRecursion(arr, sum, start, end - 1);
}
    public static void main(String[] args){
    System.out.println("Q1:\n");
       int[] arr = {2,7,12,18,19,34,56,67,70};
       long t1 = System.nanoTime();
       System.out.println("The pairs will be: ");
       int[] list =sumRecursion(arr, 19, 0, arr.length-1);
       for(int i=0;i<list.length;i++){
           System.out.println("--> "+list[i]);
       }
       long t2 = System.nanoTime();
       System.out.println("The time taken by the algorithm will be: " + (t2-t1));
       System.out.println("The running time of algorithm will be O(N^2) since the array is sorted ");
    }
    
}
