class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderRecursive(node.left, result);

        // Visit the current node
        result.add(node.val);

        // Traverse the right subtree
        inorderRecursive(node.right, result);
    }
}
