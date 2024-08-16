t.c  n* ( 4 to power n/ n to power 1.5)
  import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<TreeNode>[][] memo;

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        // Initialize the memoization array
        memo = new List[n + 1][n + 1];
        return solve(1, n);
    }

    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        // Check if the result is already computed
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = solve(start, i - 1);
            List<TreeNode> rightSubTrees = solve(i + 1, end);

            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }

        // Store the computed result in the memo array
        memo[start][end] = res;
        return res;
    }
}

