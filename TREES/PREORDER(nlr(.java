class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Return an empty list if the tree is empty.
        }

        // Add the value of the current node to the result list.
        result.add(root.val);

        // Recursively traverse the left subtree, if it exists.
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }

        // Recursively traverse the right subtree, if it exists.
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }

        return result;
    }
}



/// stack approach

 import java.util.Stack;
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) 
    {
         List<Integer> result = new ArrayList<>();
         Stack<TreeNode> s1 = new Stack<TreeNode>();
         
        if (root == null) {
            return result; // Return an empty list if the tree is empty.
        }

      s1.push(root);

      while(!s1.isEmpty())
      {
          root = s1.pop();
          result.add(root.val);


          if( root.right != null)
          {
              s1.push(root.right);
          }
          if(root.left != null)
          {
              s1.push(root.left);
          }
      }
      

return result;



    }
}



// Summary: The provided Java code defines a solution for performing a preorder traversal on a binary tree using an iterative approach. It uses a stack data structure to efficiently traverse the tree without recursion. Here's a breakdown of the code:

// A Stack<TreeNode> named s1 is created to keep track of tree nodes during the traversal, and an empty result list result is initialized to store the preorder traversal sequence.

// The code first checks if the given root node is null. If it is, an empty result list is returned, indicating an empty tree.

// If the root is not null, the code initializes the traversal by pushing the root node onto the stack s1.

// The main loop starts, which continues until the stack s1 is empty. Inside the loop, the following steps are performed for each node:

// a. The top node is popped from the stack and added to the result list, capturing the preorder traversal.

// b. If the popped node has a right child, that child is pushed onto the stack. This ensures that right subtrees are explored before left subtrees, which is characteristic of a preorder traversal.

// c. If the popped node has a left child, that child is pushed onto the stack. Left children are pushed last to ensure that they are visited after the right children in the next iteration.

// The loop continues until all nodes in the tree have been traversed, and the result list contains the preorder traversal sequence.

// Finally, the result list is returned, containing the preorder traversal of the binary tree.

// This code effectively performs a preorder traversal of a binary tree using an iterative approach and is a useful alternative to the recursive method. It's particularly suitable for large or deep trees, as it avoids the potential for stack overflow associated with recursive solutions.
