/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */   // o(N)
class Solution {
    public int countNodes(TreeNode root) 
    {
        if(root == null)
        return 0;
        if(root.left == null && root.right == null)
        return 1;      

          int c [] =new int [1];
          c[0]=0;

         findNode( root, c);

          return c[0]+1;

    }

    public void findNode(TreeNode root, int []c)
    {
        if( root ==  null)
        return;

     

           if(root.left!= null)
           {
               c[0]++;
                findNode(root.left, c);

           }
           if(root.right!=null)
           {
               c[0]++;
           findNode(root.right,c);

           }
       

    }
}

//0(log n^2) = 0(log(2n+1) * log(n)) (binary search that is dividing at each unbalanced level * traversal complexity)

// No of nodes = 2 to the power height -1( compelete binary tree).


 public int findHeightLeft(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.left; 
        }
        return hght; 
    }

public int findHeightRight(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.right; 
        }
        return hght; 
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0; 
        
        int lh = findHeightLeft(root); 
        int rh = findHeightRight(root); 
        
        if(lh == rh) return (int) Math.pow(2,lh)-1; 
        
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        
        return 1 + leftNodes + rightNodes; 
    }
}
