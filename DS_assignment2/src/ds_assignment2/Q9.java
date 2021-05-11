
package ds_assignment2;

import java.util.LinkedList;
import java.util.Queue;
 
class BSTNode1 {
     BSTNode1 left, right;
	     char data;
	 
	     public BSTNode1()
	     {
	         left = null;
	         right = null;
	         data = 'a';
	     }
	     
	     public BSTNode1(char n)
	     {
	         left = null;
	         right = null;
	         data = n;
	     }
	     /* Function to set left node */
	     public void setLeft(BSTNode1 n)
	     {
	         left = n;
	     }
	     /* Function to set right node */ 
	     public void setRight(BSTNode1 n)
	     {
	         right = n;
	     }
	     public BSTNode1 getLeft()
	     {
	         return left;
	     }
	     public BSTNode1 getRight()
	     {
	         return right;
	     }
	    
	     public void setData(char d)
	     {
	         data = d;
	     }
	    
	     public int getData()
	     {
	         return data;
	     }     
	
}
public class Q9 {
    BSTNode1 root;
    
    public Q9() {
        root = null;
    }
    
    public void insert(char data) {
        root = insert(root, data);

    }

    private BSTNode1 insert(BSTNode1 node, char data) {

        if (node == null) {
            node = new BSTNode1(data);
        } else {
            if (data < node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
   
    
    public static void display(BSTNode1 node){
        if(node==null) return;
        display(node.left);
        System.out.print(node.data +"");
        display(node.right);
    }
    

    static void representation(BSTNode1 root) 
    { 
       
        if(root == null) 
            return; 
        
        Queue<BSTNode1> q =new LinkedList<BSTNode1>(); 
         
        q.add(root); 
          
          
        while(true) 
        {  
            int nodeCount = q.size(); 
            if(nodeCount == 0) 
                break; 
             
            while(nodeCount > 0) 
            { 
                BSTNode1 node = q.peek(); 
                System.out.print(node.data + " "); 
                q.remove(); 
                if(node.left != null) 
                    q.add(node.left); 
                if(node.right != null) 
                    q.add(node.right); 
                nodeCount--; 
            } 
            System.out.println(); 
        } 
    } 

    public static void main(String[] args){
        Q9 tree = new Q9();
        tree.insert('w');
        tree.insert('e');
        tree.insert('l');
        tree.insert('c');
        tree.insert('o');
        tree.insert('m');
        tree.insert('e');
        tree.insert('t');
        tree.insert('o');
        tree.insert('c');
        tree.insert('l');
        tree.insert('a');
        tree.insert('s');
        tree.insert('s');
        System.out.println("Q9:\n");
        System.out.print("Inorder Traversal: ");
        display(tree.root);
        System.out.println("\n");
        System.out.println("Graphical representation: ");
        representation(tree.root);
        
    }
}
