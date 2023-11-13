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
// class Solution { passed 128/199 failed  12223434
//     public boolean isSymmetric(TreeNode root) {
//        if( root.left == null && root.right == null)
//        {
//            return true;
//        }
//        if( root.left != root.right)
//        {
//            return false;
//        }
//         boolean f = true;
//                if((root.left == root.right ) && (root.left != null) && (root.right!=null))
//        {
//           solve(root.left, root.right,f);
//        }
       
//        return f;
//     }
//     public void solve(TreeNode p, TreeNode q, boolean f)
//     {
//         if( p == null && q== null)
//         return;       
//         if((p.right.val != q.left.val) ||   ( p.left.val != q.right.val) )
//         {
//             f = false;
//             return;
//         }
//        else if((p.val != q.val) )
//         {
//             f = false;
//             return;
//         }
//         else // ((p.right == q.left) && ( p.left == q.right))
//         {
//            solve(p.left,q.right,f);
//            solve(p.right,q.left,f);     
//         }        
//     }
// }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
