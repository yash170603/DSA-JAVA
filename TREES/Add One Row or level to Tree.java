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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode node = new TreeNode(val);
        if(depth ==1)
        {
            TreeNode x = new TreeNode(val);
            x.left = root;
            return x;
        }
        solve( root, depth,1,node);
        return root;

    }

    public void solve( TreeNode root, int target_depth,int depthog, TreeNode node)
    {
        if( depthog +1 == target_depth)
        {
            TreeNode templ =root.left ;
            TreeNode tempr = root.right;
            TreeNode el =  new TreeNode(node.val);
            TreeNode er =new TreeNode(node.val);
            el.left= templ;
             root.left = el;
            er.right = tempr;
            root.right = er;
            return;
          
           
           
        }
        
        if( root.left  != null)
        solve( root.left, target_depth, depthog+1,node);
        if(root.right!=null)
        solve(root.right, target_depth, depthog+1,node);
        return;

    }
} // tc = o(n)
