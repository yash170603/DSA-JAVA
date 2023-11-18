import java.util.*;


class childrensum
{
    public static void main(String args[])
    {
          TreeNode root = new TreeNode(2);
          
  root . left = new TreeNode(35);
  root . left . left = new TreeNode(2);
  root . left . right = new TreeNode(3);
  root . right = new TreeNode(10);
  root . right . left = new TreeNode(5);
  root . right . right = new TreeNode(2);
         printTree(root);
         System.out.print(" ");
          solve(root);
          System.out.print(" ");    
         printTree(root);
          
    }
    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
    public static void solve(TreeNode root)
    {
        if(  ( root.left == null)  && (root.right == null))
        return;

        int x=0;
        int y=0;
        int v = root.val;


        if( root.left != null)
        {
             x = root.left.val;
        }
        if( root.right!= null)
        {
            y= root.right.val;
        }

        if(v<= (x+y))
        {
            root.val = x+y;
        }
        else  //v>x+y
        {
              if( v%2 == 0)
              {
                root.left.val = v/2;
                root.right.val=v/2;
              }
              else
              {
                root.left.val=v/2;
                root.right.val=(v/2)+1;
              }
        }
        
      solve( root.left);
      solve(root.right);
      
    }
}


// striver solution

import java.util.*;
class Node {
  int data;
  Node  left,  right;
  Node(int data)
  {
      this.data=data;
      left=null;
      right=null;
  }
}
class TUF{
static void reorder(Node  root) {
  if (root == null) return;
  int child = 0;
  if (root . left!=null) {
    child += root . left . data;
  }
  if (root . right!=null) {
    child += root . right . data;
  }

  if (child < root . data) {
    if (root . left!=null) root . left . data = root . data;
    else if (root . right!=null) root . right . data = root . data;
  }

  reorder(root . left);
  reorder(root . right);

  int tot = 0;
  if (root . left!=null) tot += root . left . data;
  if (root . right!=null) tot += root . right . data;
  if (root . left!=null || root . right!=null) root . data = tot;
}
static void changeTree(Node  root) {
  reorder(root);
}

public static void main(String args[]) {

  Node  root = new Node(2);
  root . left = new Node(35);
  root . left . left = new Node(2);
  root . left . right = new Node(3);
  root . right = new Node(10);
  root . right . left = new Node(5);
  root . right . right = new Node(2);

  changeTree(root);

}
}

