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
class BSTNode {
     BSTNode left, right;
	     int data;
	 
	     /* Constructor */
	     public BSTNode()
	     {
	         left = null;
	         right = null;
	         data = 0;
	     }
	     /* Constructor */
	     public BSTNode(int n)
	     {
	         left = null;
	         right = null;
	         data = n;
	     }
	     /* Function to set left node */
	     public void setLeft(BSTNode n)
	     {
	         left = n;
	     }
	     /* Function to set right node */ 
	     public void setRight(BSTNode n)
	     {
	         right = n;
	     }
	     /* Function to get left node */
	     public BSTNode getLeft()
	     {
	         return left;
	     }
	     /* Function to get right node */
	     public BSTNode getRight()
	     {
	         return right;
	     }
	     /* Function to set data to node */
	     public void setData(int d)
	     {
	         data = d;
	     }
	     /* Function to get data from node */
	     public int getData()
	     {
	         return data;
	     }     
	
}
public class Q4 {
    
     BSTNode root;
    
    public Q4() {
        root = null;
    }
    
    
    /* Functions to insert data */

    public void insert(int data) {
        root = insert(root, data);

    }

 /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data) {

        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    
    public boolean check_roman_node(int data){
        
        int left = count_descendents(search(root,data).getLeft());
        
        int right = count_descendents(search(root,data).getRight());
        
        return (left - right <=5) && (left - right >= -5);
    }
    
    private int count_descendents(BSTNode n){
        if (n == null)
            return 0;
        else 
           return 1 + count_descendents(n.getLeft()) + count_descendents(n.getRight());
    }
    
        private BSTNode search(BSTNode n, int val) {
        boolean flag = false;
        while ((n != null) && !flag) {
            int rval = n.getData();
            if (val < rval) {
                n = n.getLeft();
            } else if (val > rval) {
                n = n.getRight();
            } else {
                flag = true;
                break;
            }
            n = search(n, val);
        }
        return n;
    }
    
    public static void main(String[] args) {
        
        Q4 tree = new Q4();
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(2);
        tree.insert(0);
        tree.insert(13);

        System.out.println("Q4:\n");
        System.out.println("Is Node 8 a roman Node?\nAnswer: " + tree.check_roman_node(8)+"\n");
        System.out.println("Is Node 6 a roman Node?\nAnswer: " + tree.check_roman_node(6)+"\n");
        System.out.println("Is Node 13 a roman Node?\nAnswer: " + tree.check_roman_node(13)+"\n");
    }
    
    
}
