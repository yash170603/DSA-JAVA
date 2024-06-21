// recursion/**
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
      TreeNode prev;
    public void flatten(TreeNode root) {
          prev=null;
          solve(root);
          return;
    }

    public void solve( TreeNode root)
    {
        if( root == null)
        {
            return;
        }
        solve(root.right);
        solve(root.left);
        root.left = null;
        root.right = prev;
        prev = root;

    }
}



// stack
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
    
    public void flatten(TreeNode root) {
        Stack<TreeNode> tempNodes = new Stack<>();
        TreeNode currentNode = root;
        int i = 0;
        while (!tempNodes.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                tempNodes.push(currentNode.right);
                currentNode = currentNode.left;

                if (currentNode != null) {
                    root.left = null;
                    root.right = currentNode;
                    root = root.right;
                }
            }

            currentNode = tempNodes.pop();

            if (currentNode != null) {
                root.left = null;
                root.right = currentNode;
                root = root.right;
            }
        }
    }
}
