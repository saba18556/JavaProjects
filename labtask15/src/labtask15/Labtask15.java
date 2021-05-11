
package labtask15;

import java.util.*;
/**
 *
 * @author Saba Fatima
 */

class Node{
    
    int data;
    
    Node(int data){
        this.data = data;
    }
}

class edge{
    
   Node a, b;
   int weight;
   edge(Node a, Node b){
       this.a = a;
       this.b = b;
       this.weight = 1;
   }
}

class Graph{
    
    LinkedList<Node> nodes;
    LinkedList<edge> edges;
    int total_nodes;
    ArrayList<ArrayList<Integer>> list=new ArrayList<>(total_nodes);
    
    Graph(int total_nodes){
        this.total_nodes = total_nodes;
        nodes = new LinkedList();
        edges = new LinkedList();
        for(int i=0;i<total_nodes;i++){
                list.add(new ArrayList<>());
            }
    }
    
    public LinkedList<Node> addNode(Graph graph, Node node){
            nodes.add(node);
            return nodes;
        }
    
    public LinkedList<edge> addEdges(Graph graph,int x,int y){
            edge e=new edge(new Node(x), new Node(y));
            edges.add(e);
            list.get(x).add(y);
            list.get(y).add(x);
            return edges;
        }
    public LinkedList<Node> listOfNodes(Graph graph){
            return graph.nodes;
        }
        public LinkedList<edge> listOfEdges(Graph graph){
            return graph.edges;
        }
        public ArrayList<Integer> getNeighbors(Node node){
            System.out.println("The neighboring nodes of " + node.data + " are: ");
            return(list.get(node.data));
        }
        public void removeNode(Graph g, Node node){
            g.list.remove(node.data);
            for(int i=0;i<list.size();i++){
                for(int j=0;j<list.get(i).size();j++){
                    if(list.get(i).get(j)==node.data)
                        list.get(i).remove(j);
                }
            }
            total_nodes--;
        }
        public void display_adj_matrix( Graph g){
            int [][] arr=new int[5][5];
            for(int i=0;i<total_nodes;i++){
                for(int j=0;j<arr[i].length;j++){
                    arr[i][j]=0;
                }
            }
            for(int i=0;i<arr.length;i++){
                for(Integer j: list.get(i))
                    arr[i][j]=1;
            }
            for(int i=0;i<total_nodes;i++){
                for(int j=0;j<total_nodes;j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }
        }
        public void displayGraph(){
            displayGraph(list);
        }
        public void displayGraph(ArrayList<ArrayList<Integer> > node) { 
		for (int i = 0; i < node.size(); i++) { 
			System.out.println("\nAdjacency list of vertex-" + i); 
			System.out.print("head"); 
			for (int j = 0; j < node.get(i).size(); j++) { 
				System.out.print(" -> "+node.get(i).get(j)); 
			} 
			System.out.println(); 
		} 
	} 
}   
    


public class Labtask15 {

    
    public static void main(String[] args) {
        
        Graph graph = new Graph(5);
          LinkedList<Node> nodes = new LinkedList<>();
          LinkedList<edge> edges = new LinkedList<>();
          
          for(int i=0;i<5;i++){
              
              nodes = graph.addNode(graph, new Node(i));
              
          } 
          
          graph.addEdges(graph, 0, 1);
          graph.addEdges(graph, 0, 4);
          graph.addEdges(graph, 1, 2);
          graph.addEdges(graph, 1, 3);
          graph.addEdges(graph, 1, 4);
          graph.addEdges(graph, 2, 3);
          graph.addEdges(graph, 3, 4);
          edges = graph.edges;
          graph.displayGraph();
          System.out.println("\n----------------------------\n");
          graph.display_adj_matrix(graph);
          System.out.println("\n----------------------------");
          graph.removeNode(graph, nodes.get(4));
          System.out.println("\nAfter removing 4th vertex:");
          graph.displayGraph();
        
    }
    
}
