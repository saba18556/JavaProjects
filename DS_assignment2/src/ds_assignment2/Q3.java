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

class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class LCA{
    Node root;
    
    
    
    public Node lca(int a, int b, Node node){
        if(node==null) return null;
        if(node.data==a||node.data==b) return node;
        Node left = lca(a, b, node.left);
        Node right = lca(a, b, node.right);
        if (left!=null && right!=null) return node;
        if (left!= null) return left; 
        else return right;
    }
}
public class Q3 {
    
    public static void main(String[] args){
        System.out.println("Q3:\n");
       LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left= new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("The LCA of 4 and 5 is: " + tree.lca(4, 5, tree.root).data);
        System.out.println("The LCA of 3 and 4 is: " + tree.lca(3, 4, tree.root).data);
        System.out.println("The LCA of 6 and 7 is: " + tree.lca(6, 7, tree.root).data);
        System.out.println("The LCA of 7 and 3 is: " + tree.lca(7, 3, tree.root).data);
        System.out.println("The running time of this algorithm is O(N)");
        System.out.println("\n----------------------------------------------\n");
    }
    
}
