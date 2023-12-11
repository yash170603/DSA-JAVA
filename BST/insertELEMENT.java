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
    public TreeNode insertIntoBST(TreeNode root, int val)
     {
         TreeNode VAL= new TreeNode (val);
         if(root  == null)
         return VAL;

         solve(root,VAL,val);

         return root;       
    }
    public void solve(TreeNode root, TreeNode VAL, int val)
    {
        if(root.val>val)
        {
            if(root.left!= null)
            {
                root=root.left;
                solve(root,VAL,val);
            }
            else
            root.left = VAL;
        }
        if(root.val<val)
        {
            if(root.right!= null)
            {
                root=root.right;
                solve(root,VAL,val);
            }
            else
            root.right = VAL;
        }
    }
}
