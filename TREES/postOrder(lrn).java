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
    public List<Integer> postorderTraversal(TreeNode root)
     {
         List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

       private void postorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        postorderRecursive(node.left, result);

        // Visit the current node
        

        // Traverse the right subtree
        postorderRecursive(node.right, result);

        result.add(node.val);
    }
}
