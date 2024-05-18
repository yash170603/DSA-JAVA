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
    int ans;
    public int distributeCoins(TreeNode root) {
        if(root==null)
        return 0;
        ans=0;
        int u =solve( root);
        return ans;
    }
    

    public int solve( TreeNode root)
    {
        if( root == null)
        return 0;


        int a = solve( root.left);
        int b = solve( root.right);

        ans += Math.abs(a)+Math.abs(b);

        return (a+b+root.val)-1;
    }
}
