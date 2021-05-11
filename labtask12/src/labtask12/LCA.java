
package labtask12;


public class LCA {
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
    Node root ;
     LCA(){
      root = null;
    }
    
   
    public Node lca(int a, int b, Node node){
        if(node==null) return null;
        if(node.data==a||node.data==b) return node;
        Node left = lca(a, b, node.left);
        Node right = lca(a, b, node.right);
        if (left!=null && right!=null) return node;
        return (left!= null) ? left : right;
    }
    
}
