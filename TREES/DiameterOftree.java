// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root)
//      {
//          if( root == null)
//          return 0;
//      int max[]=new int[10];
//      temp(root,max);
//      return max[0];      
//     }
//     public void temp(TreeNode root, int[] max)
//     {
//         if( root == null)
//          return ; 
            
//        int a = maxdepth(root.left);
//        int b=  maxdepth(root.right);
//        int c = a+b;
//         max[0] = Math.max(max[0],c);
//         if( root.left!=null)
//         {
//              temp(root.left,max);
//         }
//        if(root.right!=null)
//        {
//               temp(root.right,max);             diameter =! height,, diameter is always less than no of nodes, i.e 4 nodes= 3 diameter,
//        }                                         this solution is slow, founded left height and right height of root, and added them
       
//     }
//     public int maxdepth(TreeNode root)
//     {
//         if(root == null)
//         return 0;
//         int x = maxdepth(root.left);
//         int y= maxdepth(root.right);
//         return Math.max(x,y)+1;
//     }
// }/
// last node ki height == 1, but diameter is always 0, diameter is derived by height, left and right heighy of each is calculated,
// then updated in diameter array, and then the maximum length is returned
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
