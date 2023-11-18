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
