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
public class Q7 {
    
    public static void combine_heaps(int[] T1, int[] T2){
        
        int len1 = T1.length;
        int len2 = T2.length;
        int final_len = T1.length + T2.length;
        int[] heap = new int[final_len];
        System.arraycopy(T1,0,heap,0,len1);
        System.arraycopy(T2, 0, heap, len1, len2);
        buildHeap(heap,final_len);
        for(int i=0;i<heap.length;i++){
            System.out.print(heap[i] + " ");
        }
    }

    
    static void buildHeap(int arr[], int n) 
    { 
        
        int startIdx = (n / 2) - 1; 
  
        for (int i = startIdx; i >= 0; i--) { 
            heapify(arr, n, i); 
        } 
    } 
  
    
    static void heapify(int arr[], int n, int i)
	{
		int largest = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		
		if (l < n && arr[l] > arr[largest])
			largest = l;

		
		if (r < n && arr[r] > arr[largest])
			largest = r;

		
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			
			heapify(arr, n, largest);
		}
	}
    public static void main(String[] args){
        System.out.println("Q7:\n");
        System.out.println("Input:");
        System.out.println("heap 1 = {3,6,1,17,2,9,33,10,22}");
        System.out.println("heap 2 = {8,5,14,20,19,32,50}");
        System.out.println();
        int[] T1 = {3,6,1,17,2,9,33,10,22};
        buildHeap(T1,T1.length);
        int[] T2 = {8,5,14,20,19,32,50};
        buildHeap(T2,T2.length);
        System.out.println("Output:");
        combine_heaps(T1,T2);
        
    }
}
