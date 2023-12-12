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


//deletion

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        return solve(root, key);
    }

    public TreeNode solve(TreeNode root, int k) {
        if (root == null)
            return null;

        if (root.val == k) {
            if (root.left == null && root.right == null) {
                return null; // Node with no children
            } else if (root.left == null) {
                return root.right; // Node with only right child
            } else if (root.right == null) {
                return root.left; // Node with only left child
            } else {
                // Node with both left and right children
                root.val = minValue(root.right);
                root.right = solve(root.right, root.val);
                return root;
            }
        }

        if (root.val < k) {
            root.right = solve(root.right, k);
        } else {
            root.left = solve(root.left, k);
        }

        return root;
    }

    public int minValue(TreeNode root) {
        if (root == null) {
            return -1; // Handle the case where the tree is empty
        }

        while (root.left != null) {
            root = root.left;
        }

        int x = root.val;
        return x;
    }

    // Additional methods...
}

/*The time complexity of your `deleteNode` operation in a Binary Search Tree (BST) depends on the height of the tree. In the worst case,
the height of the tree can be \(O(n)\), where \(n\) is the number of nodes in the tree.

Here's a breakdown of the time complexity for various cases:

1. **Deleting a Leaf Node:**
   - If the node to be deleted is a leaf (has no children), the operation takes constant time \(O(1)\) because you simply remove the node.

2. **Deleting a Node with One Child:**
   - If the node has one child, you replace the node with its child, and this operation also takes constant time \(O(1)\).

3. **Deleting a Node with Two Children:**
   - If the node to be deleted has two children, your implementation replaces the node's value with the minimum value
   from its right subtree and then recursively deletes the node containing the minimum value in the right subtree.
   This operation takes \(O(h)\) time, where \(h\) is the height of the tree.

4. **Worst Case:**
   - If the tree is unbalanced, and the height is \(O(n)\), the overall time complexity for the `deleteNode` operation is \(O(n)\).

To improve the average-case time complexity, consider using a self-balancing Binary Search Tree (BST), such as an AVL tree or a Red-Black tree.
These trees maintain balance during insertion and deletion operations, ensuring that the height of the tree remains \(O(\log n)\), 
leading to \(O(\log n)\) time complexity for deletion operations on average.*/
