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
