/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

/**
 *
 * @author Saba Fatima
 */


//import java.util.*; 


public class Exam2 {
   
static class Node 
{ 
	int data; 
	Node left, right; 
} 

public static class val { 
	int v; 
	val(int a) 
	{ 
		v = a; 
	} 
} 
static Node newnode(int data) 
{ 
	Node node = new Node(); 
	node.data = data; 
	node.left = node.right = null; 
	return (node); 
} 
static boolean sumSubtrees(Node ptr, val s, int sum) 
{ 
	// base condition 
	if (ptr == null) 
	{ 
		s = new val(0); 
		return false; 
	} 

	val sum_left = new val(0), sum_right = new val(0); 
	return (sumSubtrees(ptr.left, sum_left, sum) || sumSubtrees(ptr.right, sum_right, sum) || ((s.v = sum_left.v + sum_right.v + ptr.data) == sum)); 
} 


static boolean sumSubtree(Node root, int sum) 
{ 
	
	val s = new val(0); 

	return sumSubtrees(root, s, sum); 
} 


// Driver Code 
public static void main(String args[]) 
{ 
	Node root = newnode(2); 
	root.left = newnode(7); 
	root.left.right = newnode(5); 
	root.right = newnode(6); 
	root.right.left = newnode(8); 
	int sum = 14; 

	if (sumSubtree(root, sum)) 
		System.out.println( "Yes"); 
	else
		System.out.println( "No"); 
} 
} 




    
    