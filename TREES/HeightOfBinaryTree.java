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
// class Solution {
//     public int maxDepth(TreeNode root) 
//     {
//       List<List<Integer>> ans = new ArrayList<>();
//      int count = 1;
//         if (root == null) {
//             return 0;
//         }
//         functionGivesAns(root, ans);
//         return ans.size();   
//     }
//     public void functionGivesAns(TreeNode root, List<List<Integer>> ans) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int levelSize = queue.size();
//             List<Integer> levelValues = new ArrayList<>();

//             for (int i = 0; i < levelSize; i++) {
//                 TreeNode node = queue.poll();
//                 if (node != null) {
//                     levelValues.add(node.val);

//                     if (node.left != null) {
//                         queue.offer(node.left);
//                     }
//                     if (node.right != null) {
//                         queue.offer(node.right);
//                     }
//                 }
//             }

//             ans.add(levelValues);
        
           

//         }
//     }
// }
class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}
