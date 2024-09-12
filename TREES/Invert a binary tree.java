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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
        return null;
        int rootVal = root.val;
        TreeNode parent = new TreeNode( root.val);
        dfs(root,parent);
        return parent;
    }
    public void dfs( TreeNode root, TreeNode parent){
         TreeNode leftKid =  (root.right != null)? new TreeNode( root.right.val):null;
         TreeNode rightKid = (root.left !=null) ?new TreeNode(root.left.val):null;
         parent.left=leftKid;
         parent.right = rightKid;
         if( root.right!=null)
         dfs( root.right, leftKid);
         if(root.left!=null)
         dfs( root.left, rightKid);
         return;
    }
}
