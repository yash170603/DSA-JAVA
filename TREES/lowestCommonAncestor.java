// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// import java.util.ArrayList;

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
//      {
//         ArrayList<Integer> x1 = new ArrayList<Integer>();
//         ArrayList<Integer> x2 = new ArrayList<Integer>();
//         boolean b1 = false;
//         boolean b2 = false;                     on2
//        int xx =Integer.MAX_VALUE;
//         b1 = getPath(root, x1, p.val);
//         b2 = getPath(root,x2,q.val);
//         for( int i=0;i<x1.size();i++)
//         {
//             int y = x1.get(i);
//             for( int j =0;j<x2.size();j++)
//             {
//                      int u = x2.get(j);
//                       if(y == u)
//                {
//                    xx = y;
//                }
//             }
          
//         }
//      TreeNode dd = new TreeNode(xx);
//      return dd;
//     }
//      public  boolean getPath(TreeNode root, ArrayList < Integer > arr, int x) {       
//         if (root == null)
//             return false;
//         arr.add(root.val);
//         if (root.val == x)
//             return true;
//         if (getPath(root.left, arr, x) ||
//             getPath(root.right, arr, x))
//             return true;
//         arr.remove(arr.size() - 1);
//         return false;
//     }
// }/
class Solution { //booth null = null, 1 null return left / right,, both not null return root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;                    //oN
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
}
