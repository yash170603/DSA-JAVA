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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        functionGivesAns(root, ans);

        int d = ans.size();
        for( int i =0;i<d;i++)
        {
            if( i%2 !=0)
            {
                modify(ans.get(i));
            }
        }

        return ans;
    }
     public void functionGivesAns(TreeNode root, List<List<Integer>> ans) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelValues.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            ans.add(levelValues);
        }
    }

    public void modify(List<Integer> x)
    {
        Collections.reverse(x);
    }
}
