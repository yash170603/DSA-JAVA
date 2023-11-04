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
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {

       
       if(p == null && q == null)
       return true;
       if(p == null || q== null)
       return false;
    
       
       boolean a = false;
       boolean b= false;
      

    //  if(p.left!=null && q.left!=null)
                 b=  isSameTree(p.left,q.left);
                // if(p.right!=null && q.right !=null)
              a=  isSameTree(p.right,q.right);

       if( a ==false || b ==false)
         return false; 
         if(p.val != q.val)
         return false;
    
         return true;
         
    }
}
//     public void inorder(TreeNode root,List<Integer>x)
//     {
//         if(root == null)
//         return;
//  // Traverse the left subtree
//         inorder(root.left, x);

//         // Visit the current node
//         x.add(root.val);

//         // Traverse the right subtree
//         inorder(root.right, x);
//     }    this passed 59/61 cases





// 2nd approach, i dont give a shit about

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // Both trees are empty, so they are the same.
            return true;
        }
        
        if (p == null || q == null) {
            // One tree is empty, the other is not, so they are not the same.
            return false;
        }

        // Check if the current nodes are the same and recursively check the left and right subtrees.
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      //return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}

