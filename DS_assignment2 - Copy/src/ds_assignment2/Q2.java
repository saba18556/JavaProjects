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
public class Q2 {
    
     public static int row_with_ones(int[][] list){
       int x=0;
       for(int i=0;i<list.length;i++){
           if(list[list.length-1][i]!=1) {
               break;
           }
           x++;
       }
       int y = x;
        for(int i=list.length-2;i>=0;i--){
            y+=x;
            for(int j=x;j<list.length;j++){
                if(list[i][j]!=1){
                    break;
                }
                x++;
                y++;
            }
        }
       return (y/list.length);
     }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Q2:\n");
       int[][] arr1 = {{1,1,1,0,0},{1,1,0,0,0},{1,1,1,1,0},{0,0,0,0,0},{1,1,0,0,0}};
        System.out.println("Input:\n1,1,1,0,0\n"
                + "1,1,0,0,0\n"
                + "1,1,1,1,0\n"
                + "0,0,0,0,0\n"
                + "1,1,0,0,0");
       System.out.println("\nOutput: "+row_with_ones(arr1));
    }
    
}
