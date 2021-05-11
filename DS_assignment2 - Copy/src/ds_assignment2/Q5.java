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

import java.util.Stack;

class Nodes
{
    public char data;
    public Nodes left;
    public Nodes right;
 
    public Nodes(char x)
    {
        data = x;
        left = right = null;
    }
 
    public void displayNode()
    {
        System.out.print(data);
    }
}

class BinExp
{
     Stack<Character> s;
     String input;
     String output = "";
 
    public BinExp(String str)
    {
        input = str;
        s = new Stack<>();
    }
 
    public String precedenceOf()
    {
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            switch (ch)
            {
                case '+':
                case '-':
                    hasOp(ch, 1);
                    break;
                case '*':
                case '/':
                    hasOp(ch, 2);
                    break;
                case '(':
                    s.push(ch);
                    break;
                case ')':
                    hasBrackets();
                    break;
                default:
                    output = output + ch;
            }
        }
        while (!s.isEmpty())
            output = output + s.pop();
        return output;
    }
    
    private void hasOp(char opThis, int prec1)
    {
        while (!s.isEmpty())
        {
            char op = s.pop();
            if (op == '(')
            {
                s.push(op);
                break;
            } else
            {
                int prec2;
                if (op == '+' || op == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1)
                {
                    s.push(op);
                    break;
                } else
                    output = output + op;
            }
        }
        s.push(opThis);
    }
    private void hasBrackets()
    {
        while (!s.isEmpty())
        {
            char ch = s.pop();
            if (ch == '(')
                break;
            else
                output = output + ch;
        }
    }
}

class Tree
{
     Nodes root;
 
    public Tree()
    {
        root = null;
    }
 
    
}
public class Q5 {
    
    public static void display(String s)
    {
        Tree tree = new Tree();
        BinExp exp = new BinExp(s);
        s = exp.precedenceOf();
        Stack<Nodes> s1 = new Stack<>();
        s = s + "&";
        int i = 0;
        char ch = s.charAt(i);
        Nodes newNode;
        while (ch != '&')
        {
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            {
                newNode = new Nodes(ch);
                s1.push(newNode);
            } else if (ch == '+' || ch == '-' || ch == '/'|| ch == '*')
            { Nodes temp1 = s1.pop();
                Nodes temp2 = s1.pop();
                newNode = new Nodes(ch);
                newNode.left = temp2;
                newNode.right = temp1;
                s1.push(newNode);
            }
            ch = s.charAt(++i);
        }
        tree.root = s1.pop();
        System.out.println("Root will be: "+ "("+tree.root.data+")");
        System.out.print("Postfix form of the expression: ");
        postOrder(tree.root);
        System.out.println();
        
        
    }
    
    public static void postOrder(Nodes root){
        
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            root.displayNode();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Q5:\n");
        System.out.println("Input: (A+B)*(C+D)\n");
        System.out.println("Output: ");display("(A+B)*(C+D)");
        
    }
    
}

