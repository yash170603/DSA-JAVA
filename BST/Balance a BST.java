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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> a= new ArrayList<>();
        inorder(root,a);
        return solve(0,a.size()-1,a);
    }

    public TreeNode solve( int left, int right, ArrayList<Integer> a)
    {
        if( left>right)
        return null;
        int mid = left+ (right-left)/2;
        TreeNode root= new TreeNode(a.get(mid));
        root.left= solve( left, mid-1,a);
        root.right = solve(mid+1, right, a);
        return root;
    }
    public void inorder(TreeNode root,ArrayList<Integer> a)
    {
        if ( root == null)
        {
            return;
        }
        inorder(root.left,a);
        a.add(root.val);
        inorder(root.right,a);
        return;
    }
}
