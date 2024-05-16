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
    public boolean evaluateTree(TreeNode root) {
        if( root.val == 0 && root.left == null && root.right==null)
        {
            return false;
        }
        int ans = dfs( root);
        return (ans == 0)?false:true;     
    }
    public int dfs(TreeNode root)
    {
        if( root.left ==null && root.right == null)
        return root.val;
        int a = dfs(root.left);
        int b = dfs(root.right);  
        if( root.val == 3 &&( (a==0 && b==1) || ( a==1 && b==0) || (a==0 && b==0)))   
        return 0;
         if( root.val == 2 &&( (a==0 && b==0)))   
        return 0;
        return 1;
    }
}
