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
    public int sumNumbers(TreeNode root) {
        if(root.left == null && root.right == null)
        return root.val;
     int ans=0;
       List<Integer> x = new ArrayList<Integer>();
        solve( root,-1,x);
        for( int i:x){
            ans+=i;
        }
        return ans;
    }

    public void solve( TreeNode root, int temp, List<Integer> x)
    {
        if( root==null)
        return;

        if( root.left == null && root.right == null)
        {
            int y = temp*10 + root.val;
            x.add(y);
            return;
        }
       
        if( temp == -1)
        temp = root.val;
         else
        temp = temp*10 + root.val;
      int original= temp;
        solve( root.left,temp,x);
        solve( root.right, temp,x);
       temp = original;
        return;
    }
}
