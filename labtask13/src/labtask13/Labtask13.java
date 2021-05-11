
package labtask13;

import java.util.Random;

class MergeSort 
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

public class Labtask13 {
    
    public static void heapify(Integer[] list, int low, int high)
{
    int largeIndex;
    Comparable<Integer> temp =
             (Comparable<Integer>) list[low];  //copy the root node of the subtree
    largeIndex = 2 * low + 1;  //index of the left child
    while (largeIndex <= high)
    {
        if (largeIndex < high)
        {
            Comparable<Integer> compElem =
                     (Comparable<Integer>) list[largeIndex];
            if (compElem.compareTo(list[largeIndex + 1]) < 0)
                largeIndex = largeIndex + 1; //index of the largest child
        }

if (temp.compareTo(list[largeIndex]) > 0) //subtree
                                              //is already in a heap
            break;
        else
        {
            list[low] = list[largeIndex]; //move the larger
                                          //child to the root
            low = largeIndex;    //go to the subtree to
                                 //restore the heap
            largeIndex = 2 * low + 1;
        }
    }//end while
    list[low] = (Integer) temp; //insert temp into the tree,
                          //that is, list
}//end heapify


//Method buildHeap
public static void buildHeap(Integer[] list, int length)
{
    for (int index = length / 2 - 1; index >= 0; index--)
         heapify(list, index, length - 1);
}//end buildHeap

//Method heapSort
public static void heapSort(Integer[] list, int length)
{
    buildHeap(list, length);
    for (int lastOutOfOrder = length - 1; lastOutOfOrder >= 0;
                              lastOutOfOrder--)
    {
        Integer temp = list[lastOutOfOrder];
        list[lastOutOfOrder] = list[0];
        list[0] = temp;
        heapify(list, 0, lastOutOfOrder - 1);
    }//end for
}//end heapSort




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
        MergeSort ob = new MergeSort();
        long ti = System.nanoTime();
        ob.sort(arr1, 0, arr1.length - 1);
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
        Integer[] arr1 = new Integer[size1];
        for(int i=0; i<size1; i++){
            arr1[i] = i*5;
        }
        MergeSort ob = new MergeSort();
        long ta = System.nanoTime();
        ob.sort(arr, 0, arr.length - 1);
        long ts = System.nanoTime();
        System.out.println("Time used by Merge sort: "+ (ts - ta) + " Length: "+size1);
        
        long t1 = System.nanoTime();
        heapSort(arr1, arr.length-1);
        long t2 = System.nanoTime();
        System.out.println("Time used by Heap Sort: " + (t2-t1) + " Length: "+size1);
        
        
         n1++;
         size1+=5;
            System.out.println("---------------------------------");
        }while(n1!=10);
        
    }
    
}
