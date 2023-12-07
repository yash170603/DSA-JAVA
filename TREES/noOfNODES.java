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
 */
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
