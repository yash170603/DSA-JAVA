// // /**
// //  * Definition for a binary tree node.
// //  * public class TreeNode {
// //  *     int val;
// //  *     TreeNode left;
// //  *     TreeNode right;
// //  *     TreeNode() {}
// //  *     TreeNode(int val) { this.val = val; }
// //  *     TreeNode(int val, TreeNode left, TreeNode right) {
// //  *         this.val = val;
// //  *         this.left = left;
// //  *         this.right = right;
// //  *     }
// //  * }                                           
// //  */
// class Solution {
//     public int maxPathSum(TreeNode root) 
//     {
//         if(root.left == null && root.right == null)
//         return root.val;
//         int ans[] = new int[2];
//         ans[0] =Integer.MIN_VALUE; passes 66 cases,,, do ans[0] = root.val, passes 75, failed for 1,-2,3
//         fn1(root,ans);
//         return ans[0];
//     }
//     public void fn1(TreeNode root, int [] ans)
//     {      
//       if ( root == null)
//       return;
//       int x = fn2(root.left);
//       int y = fn2(root.right);
//       int c = x+y;
//       ans[0] = Math.max(ans[0], c+root.val);
//       fn1(root.left,ans);
//       fn1(root.right,ans);
//     }
//     public int fn2(TreeNode root)
//     {
//          if( root== null )
//          return 0;
//          int a = fn2(root.left);
//          int b = fn2(root.right);
//          return Math.max(a,b)+root.val;
//     }
// }
class Solution {

    public static int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
//add both left and right trees values with root in maxvalue, and return only max lengthed tree with adding root value
    public static int maxPathDown(TreeNode root, int maxValue[]) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left, maxValue));
        int right = Math.max(0, maxPathDown(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
