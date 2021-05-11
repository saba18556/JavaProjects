
package labtask12;

import java.util.Random;
import java.util.Scanner;

public class Labtask12 {
    
    static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);  
        for (int j=low; j<high; j++) 
        { 
             
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    
    static void quick_sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            quick_sort(arr, low, pi-1); 
            quick_sort(arr, pi+1, high); 
        } 
    } 
    
    public static void sort(int arr[])
	{
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}
    
    static void heapify(int arr[], int n, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}


    public static void main(String[] args) {
        
        System.out.println("Q1:\n");
        int n = 0;
        int size = 5;
        do{
        
        int[] arr1 = new int[size];
        for(int i=0; i<size; i++){
            arr1[i] = i*5;
        }
        Random rand = new Random();
        for(int i=0;i<arr1.length;i++){
            int index = rand.nextInt(arr1.length);
            int temp = arr1[index];
            arr1[index] = arr1[i];
            arr1[i] = temp;
        }
        
        long ti = System.nanoTime();
        sort(arr1);
        long tf = System.nanoTime();
        System.out.println("Time used by Heap sort: "+ (tf - ti) + " Length: " + size);
        
         n++;
         size+=5;
            System.out.println("---------------------------------");
        }while(n!=10);
        
        System.out.println();
        System.out.println("Q2:\n");
        
        int n1 = 0;
        int size1 = 5;
        do{
        
        int[] arr = new int[size1];
        for(int i=0; i<size1; i++){
            arr[i] = i*5;
        }
        long ta = System.nanoTime();
        sort(arr);
        long ts = System.nanoTime();
        System.out.println("Time used by Heap sort: "+ (ts - ta) + " Length: "+size1);
        long t1 = System.nanoTime();
        quick_sort(arr, 0, arr.length-1);
        long t2 = System.nanoTime();
        System.out.println("Time used by Quick Sort: " + (t2-t1) + " Length: "+size1);
        
        
         n1++;
         size1+=5;
            System.out.println("---------------------------------");
        }while(n1!=10);
        
    }
    
}
