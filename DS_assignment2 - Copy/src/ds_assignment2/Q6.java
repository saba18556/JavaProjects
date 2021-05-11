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
public class Q6 {
    

    static void buildHeap(int arr[], int n) 
    { 
        
        int startIdx = (n / 2) - 1; 
  
        for (int i = startIdx; i >= 0; i--) { 
            heapify(arr, n, i); 
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
    public static void key_value_less(int[] arr, int key){
        buildHeap(arr, arr.length);
        for(int i=0;i<arr.length;i++){
            if(key>=arr[i]){
                System.out.println("--> "+arr[i]);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Q6:\n");
        System.out.println("Input: ");
        System.out.println("Array= {6, 7, 1, 13, 2, 14, 9, 3}\nkey= 7\n");
        int[] arr = {6, 7, 1, 13, 2, 14, 9, 3};
        System.out.println("Output: ");key_value_less(arr, 7);
    }

}
