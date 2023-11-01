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
// using 2 Stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
            return postOrder;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);

            if (curr.left != null)
                s1.push(curr.left);

            if (curr.right != null)
                s1.push(curr.right);
        }

        while (!s2.isEmpty()) {
            postOrder.add(s2.pop().val);
        }

        return postOrder;
    }
}

// using 2 stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
            return postOrder;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != lastVisited) {
                    cur = temp.right;
                } else {
                    stack.pop();
                    postOrder.add(temp.val);
                    lastVisited = temp;
                }
            }
        }
        return postOrder;
    }
}

