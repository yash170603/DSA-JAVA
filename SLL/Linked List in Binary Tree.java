class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // Start DFS traversal from each node of the binary tree
        return dfs(root, head);
    }

  
    private boolean dfs(TreeNode root, ListNode head) {
        if (root == null) return false;
        
        // Check if there's a matching path starting from this node
        if (isMatch(root, head)) return true;

        // Continue searching in the left and right subtrees
        return dfs(root.left, head) || dfs(root.right, head);
    }

    private boolean isMatch(TreeNode root, ListNode head) {
        // If we've reached the end of the linked list, it means we matched the entire list
        if (head == null) return true;
        // If we've reached the end of the tree, but the list is not fully matched
        if (root == null) return false;
        // If the current tree node doesn't match the current list node
        if (root.val != head.val) return false;
        
        // Continue checking the next node in the list against both left and right subtrees
        return isMatch(root.left, head.next) || isMatch(root.right, head.next);
    }
}
