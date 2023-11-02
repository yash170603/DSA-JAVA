// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isBalanced(TreeNode root) 
//     {
//         if(root == null)
//         return true;
//         int x = maxDepth(root.left);
//         int y = maxDepth(root.right);
//         if(Math.abs(x-y)>1)
//         {
//             return false;
//         }

//      boolean a =   isBalanced(root.left);
//       boolean b =    isBalanced(root.right);
//       if(a == false  || b == false)
//       return false;
   
//       return true;
//     }
    
   

//      public int maxDepth(TreeNode root) {
//         // Base Condition
//         if(root == null) return 0;
//         // Hypothesis
//         int left = maxDepth(root.left);
//         int right = maxDepth(root.right);
//         // Induction
//         return Math.max(left, right) + 1;
//     }
// }
class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)  return true;
        // Height Function will return -1, when it’s an unbalanced tree...
		if (Height(root) == -1)  return false;
		return true;
	}
    // Create a function to return the “height” of a current subtree using recursion...
	public int Height(TreeNode root) {
        // Base case...
		if (root == null)  return 0;
        // Height of left subtree...
		int leftHeight = Height(root.left);
        // Height of height subtree...
		int rightHight = Height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
		if (leftHeight == -1 || rightHight == -1)  return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
		return Math.max(leftHeight, rightHight) + 1;
    }
}
