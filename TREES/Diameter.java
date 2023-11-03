//longest edges making a path, may or maynot pass through root.
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
//               temp(root.right,max);
//        }
       
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
