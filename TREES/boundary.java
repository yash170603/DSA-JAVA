

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