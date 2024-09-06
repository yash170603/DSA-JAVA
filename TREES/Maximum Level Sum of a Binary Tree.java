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
    public int maxLevelSum(TreeNode root) {
      Queue<TreeNode> q = new  LinkedList<>();
      q.offer(root);
      int ans =root.val;
      int index=1;
      int indexAns=1;
      while(!q.isEmpty()){
          int size = q.size();
          int currSum=0;
          for(int i =0;i< size;i++){
              TreeNode child= q.poll();
              int val= child.val;
               currSum+=val;
               if(child.left!=null)
               q.offer(child.left);
               if(child.right!=null)
               q.offer(child.right);
          }
            if(currSum>ans){
                ans=currSum;
                indexAns=index;
            }
            index++;
      }

      return indexAns;
    }
}
