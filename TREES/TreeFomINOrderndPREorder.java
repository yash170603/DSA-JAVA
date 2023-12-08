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
/*The time complexity of constructing a binary tree from its preorder and inorder traversal representations using the provided algorithm is \( O(n) \), where \( n \) is the number of nodes in the binary tree.

Here's a breakdown of the time complexity:

- Building the hashmap (`inMap`) for the inorder traversal takes \( O(n) \) time, where \( n \) is the number of nodes.
- The recursive `buildTree` function is called for each node of the tree.
  - At each level of recursion, the function constructs a node, performs a lookup in the hashmap (`inMap`), and calculates the number of nodes in the left subtree.
  - The total number of nodes processed across all recursive calls is linear, as each node is processed only once.
  - Within each call of `buildTree`, there's constant time work done for constructing nodes and calculating indices, resulting in \( O(1) \) operations per node.
  - Since each node is visited once, the overall complexity of the `buildTree` function is \( O(n) \).

Therefore, the total time complexity for constructing the binary tree using this algorithm is \( O(n) \), where \( n \) is the number of nodes in the binary tree.*/
 import java.util.HashMap;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder)
     {
          Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, 
    inorder.length - 1, inMap);
    return root;

    }

   public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[]
  inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, 
    inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, 
    inRoot + 1, inEnd, inMap);

    return root;
  }
}
