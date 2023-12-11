/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/


public class Solution
{
    public static int minValue(Node root) 
    {if (root == null) {
            // BST is empty
           // throw new IllegalArgumentException("BST is empty");
           return -1;
        }

        // Traverse to the leftmost node
        while (root.left != null) {
            root = root.left;
        }

        // The leftmost node contains the minimum value
        return root.data;
       
    }

}
