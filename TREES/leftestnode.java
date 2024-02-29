class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int last = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    last = curr.val;  // last leftMost val
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return last;
    }
}





class Solution {
    int leftMostValue;
    int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        leftMostValue = 0;
        maxDepth = -1;
        dfs(root, 0);
        return leftMostValue;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null)
            return;

        if (depth > maxDepth) {
            leftMostValue = node.val;
            maxDepth = depth;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
