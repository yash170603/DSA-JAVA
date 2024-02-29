// observer krte chutoye easy tha ye  solvw nahi hua gandu se

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<NodeLevel> queue = new LinkedList<>();
        queue.offer(new NodeLevel(root, 0));

        while (!queue.isEmpty()) {
            int prevNodeVal = (queue.peek().level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek().node;
                int level = queue.peek().level;
                queue.poll();

                if ((level % 2 == 0 && (node.val % 2 == 0 || node.val <= prevNodeVal)) ||
                    (level % 2 != 0 && (node.val % 2 != 0 || node.val >= prevNodeVal))) {
                    return false;
                }

                prevNodeVal = node.val;

                if (node.left != null)
                    queue.offer(new NodeLevel(node.left, level + 1));
                if (node.right != null)
                    queue.offer(new NodeLevel(node.right, level + 1));
            }
        }

        return true;
    }
}

class NodeLevel {
    TreeNode node;
    int level;

    NodeLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
