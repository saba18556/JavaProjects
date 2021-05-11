
package labtask11;

import java.util.ArrayList;

class rectangle {

    private int id;
    private double length;
    private double breadth;
    private String Color;

    public rectangle(int id, double length, double breadth, String Color) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.Color = Color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "id = " + id + ", Length = " + length + ", Breadth = " + breadth + ", Color = " + Color + "}";
    }

}


public class LabTask11 {
    
    public static void selectionSort(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int key = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[key]){  
                    key = j; 
                }  
            }  
            int smallerNumber = arr[key];   
            arr[key] = arr[i];  
            arr[i] = smallerNumber;  
        }  
        
    }
    
    public static void sort_matrix_by_row(int[][] arr){
        
        for(int i=0; i<arr.length; i++){
            selectionSort(arr[i]);
        }
    }
    
    public static void sort_matrix_by_col(int[][] arr){
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++)  { 
                
                int temp = arr[i][j]; 
                arr[i][j] = arr[j][i]; 
                arr[j][i] = temp; 
            } 
    }
        sort_matrix_by_row(arr);
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++)  { 
                
                int temp = arr[i][j]; 
                arr[i][j] = arr[j][i]; 
                arr[j][i] = temp; 
            } 
    }
    }
    
    public static int binarySearch(int[] a, int target, int max) {
        int min = 0;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            if (a[mid] < target) {
                min = mid + 1;
            } 
            else if (a[mid] > target) {
                max = mid - 1;
            }
            else {
                return mid; 
            }
        }
        return min; 
    }
    
    public static void binaryInsertionSort(int[] arr){
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int p = binarySearch(arr, key, i - 1);
            for (int j = i - 1; j >= p; j--) {
                arr[j + 1] = arr[j];
            }
            arr[p] = key;
        }
    }
    static rectangle[] sortRectangles(rectangle[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getId() > arr[j + 1].getId()) {
                    rectangle tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        
        System.out.println("Q1:");
        int[] arr1 = {8, 2, 10, 0, 6, 4, 1};

        binaryInsertionSort(arr1);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("Q2:");
        
        int[][] arr = {{1, 5, 4},
                       {7, 2, 3},
                       {5, 3, 1}};  
        System.out.println("Matrix sorted by row:");
        sort_matrix_by_row(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int[][] arrs = {{1, 5, 4},
                       {7, 2, 3},
                       {5, 3, 1}}; 
        System.out.println("Matrix sorted by column:");
        sort_matrix_by_col(arrs);
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrs[i].length;j++){
                System.out.print(arrs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Q3:");
        rectangle[] list = new rectangle[5];
        list[0] = new rectangle(9, 10.0, 20.0, "Blue");
        list[1] = new rectangle(5, 20.0, 30.0, "Red");
        list[2] = new rectangle(2, 30.0, 40.0, "Black");
        list[3] = new rectangle(1, 40.0, 50.0, "Green");
        list[4] = new rectangle(7, 50.0, 60.0, "Grey");

        rectangle[] list2 = sortRectangles(list);
        for (int i = 0; i < list2.length; i++) {
            System.out.println(list2[i].toString());
        }
        
    }
    
}
