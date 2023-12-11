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




// The time complexity of your `insertIntoBST` function is O(h), where h is the height of the binary search tree.
// In the worst case, the height of the tree is O(n), where n is the number of nodes in the tree. 
// Therefore, the worst-case time complexity is O(n).

// Let's break down the logic:

// 1. The function starts by creating a new TreeNode with the given value `val`.
// 2. It then checks if the root of the tree is null. If it is, it returns the newly created node.
// 3. If the root is not null, it calls the `solve` function, passing the root, the newly created node, and the value `val`.

// In the `solve` function:

// 1. It compares the value of the current node with the given value `val`.
// 2. If the value is greater, it recursively calls the `solve` function on the left subtree.
// 3. If the value is smaller, it recursively calls the `solve` function on the right subtree.
// 4. If the left or right child is null, it assigns the new node to that child.

// The recursion goes down the tree until it finds the appropriate position to insert the new node.
// The worst-case time complexity is O(n) when the tree is unbalanced, and the best-case time complexity is O(log n) when the tree is balanced.
