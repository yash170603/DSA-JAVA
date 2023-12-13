// this passed 50 prcnt cases but not cases like[2,1,3] and[0,-1] and [1,1] etc

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
    public boolean isValidBST(TreeNode root)
     {
         
  

  
        

         return solve(root);
        
    }

    public boolean solve(TreeNode root)
    {
       if(root == null)
        return true;     
          TreeNode x = new TreeNode();
        TreeNode y= new TreeNode();
       
        if(root.left!=null)
        x= root.left;
       if(root.right!=null)
        y = root.right;
        if( x == null && y == null)
        return true;
        if(  (x.val > root.val) || (y.val<root.val) )
        return false;
      
        
           boolean a = isValidBST(root.left);
        
       
          boolean  b = isValidBST(root.right);
        

        if(a == false || b == false)
        return false;
        return true;


    }
}

//2nd method., works fine
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        // Check if the current node's value is within the valid range
        if (val <= lower || val >= upper) {
            return false;
        }

        // Check the left subtree with updated upper bound
        // Check the right subtree with updated lower bound
        return isValidBST(node.left, lower, val) && isValidBST(node.right, val, upper);
    }
}
/*Certainly! The modified `isValidBST` function ensures that a given binary tree is a valid Binary Search Tree (BST) by recursively checking each node against
a range of values. The range is represented by lower and upper bounds.

Here's a summary with explanations:

1. **Initial Call:**
   - The initial call to `isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)` starts with no specific lower or upper bounds, allowing for an infinite range.

2. **Checking Current Node:**
   - For each node in the tree, the function checks if the node's value is within the valid range defined by the lower and upper bounds.
   - If the node's value is less than or equal to the lower bound or greater than or equal to the upper bound, the tree is not a valid BST,
   and the function returns `false`.

3. **Recursive Calls for Left and Right Subtrees:**
   - The function makes recursive calls for the left and right subtrees with updated bounds:
     - For the left subtree, the upper bound is updated to the current node's value.
     - For the right subtree, the lower bound is updated to the current node's value.

4. **Handling Infinite Bounds:**
   - To handle the case where there are no specific lower or upper bounds, the function uses `Long.MIN_VALUE` and `Long.MAX_VALUE` to represent
   negative and positive infinity, respectively.

5. **Recursive Termination:**
   - The recursion terminates when a leaf node is reached (null), and the function returns `true` for leaf nodes.

In summary, the function employs a recursive approach to traverse the binary tree, updating bounds at each step to ensure that each node's value falls 
within the correct range. This approach allows the function to determine whether the given tree is a valid BST.*/
