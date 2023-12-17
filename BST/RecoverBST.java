// first method without morris inorder, checks first and second node to be changed within the inorder traversal
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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root)
     {
         if(root == null)
         return;

         inorder(root);
         int temp = first.val;
         first.val = second.val;
         second.val = temp;
        
    }
    public void inorder(TreeNode root)
    {
        if(root == null)
        return;

        inorder(root.left);
        if(prev != null && root.val<prev.val)
        {
            if( first == null)// this condition is neccessary to check if there are only 1 prev element, like it wont wrk without this,
                              // as is 2 ( total 3 wioll be misplaced)unsorted elements occurs, for the second one the first will not be  null
                              //thus voilatin ques rules, for more than 1 root interchanged algo will be diff.
            first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);

    }
}
