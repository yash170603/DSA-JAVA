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
    public int kthSmallest(TreeNode root, int k)
     {
          if(root == null)
          return 0;
          int c=0;
          ArrayList<Integer> x = new ArrayList<Integer>();
          inorder(root,x,c,k);
          return x.get(k-1);
        
    }
    public void inorder(TreeNode root, ArrayList<Integer> x, int c , int k)
    {
        if(root == null)
        return ;
        if(c==k)
        return;

        inorder(root.left,x,c,k);
        x.add(root.val);
        c++;
        inorder(root.right,x,c,k);
    }
}
