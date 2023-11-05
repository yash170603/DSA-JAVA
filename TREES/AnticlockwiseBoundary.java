//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node root)
	{
	     ArrayList<Integer> xxx= new ArrayList<Integer>();
	    if(root.left == null && root.right == null)
	    {
	        xxx.add(root.data);
	        return xxx;
	    }
	   // return root;
	    ArrayList<Integer> xx= new ArrayList<Integer>();
	    ArrayList<Integer>x2 = new ArrayList<Integer>();
             if( root != null)
             {
               xx.add(root.data);
             leftt(root.left,xx);
             printLeaves(root,xx);
             rightt(root.right, x2);
             }
             Collections.reverse(x2);
             xx.addAll(x2);
             
             return xx;
	}
	 public   void leftt(Node root, ArrayList<Integer>x)
    {
           if( root == null)
           return;
           if((root.left == null)  && (root.right ==null))
           return;

           if(root.left !=null || root.right!=null)
           {
            x.add(root.data);
           }
        if(root.left !=null)
        {         
            leftt( root.left, x);
        }
        else
        {
            leftt(root.right, x);
        }       
    }
     public void rightt(Node root, ArrayList<Integer>x)
    {
           if( root == null)
           return;
           if((root.left == null)  && (root.right ==null))
           return;

           if(root.left !=null || root.right!=null)
           {
            x.add(root.data);
           }
        if(root.right !=null)
        {         
            rightt( root.right, x);
        }
        else
        {
            rightt(root.left, x);
        }       
    }

 public  void printLeaves(Node root, ArrayList<Integer> x) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            x.add(root.data);
        }
        printLeaves(root.left, x);
        printLeaves(root.right, x);
    }
}
