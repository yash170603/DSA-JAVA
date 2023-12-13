// my approach had issues, see the diagram in the link
https://drive.google.com/drive/folders/1Lua5WVPnuGrBiquTG0FZ6RV77cNvbdPE
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */  
//SAME TYPE HAS BEEN IN TREES.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
     {
          
          if( root == null)
          return null;
         if((p.val < root.val) && (q.val > root.val))
         return root;
          if((p.val == root.val) )
         return p;
         if((q.val == root.val))
         return q;
         
         if( (root.left == null) || (root.right == null))
         return root;

         TreeNode ans = new TreeNode();

         ans = solve(root,p,q);

         return ans;

        
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q)
    {
         TreeNode answer = new TreeNode();

         if(p.val<root.val && q.val<root.val)
         {
               int x = p.val;
               int y = q.val;
               if(x<y)
               answer.val = x;

               else
               answer.val =y;
         }
         else
       {
           int xx = p.val;
         int yy = q.val;

         if(xx>yy)
         answer.val = xx;;
        
         answer.val = yy;

       }
         

         return answer;
    }
}

// solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || ( p.val<=root.val && q.val>=root.val ) || ( p.val>=root.val && q.val<=root.val)){
            return root;
        }
         if(p.val>root.val){
             return lowestCommonAncestor( root.right,  p,  q);
         }
          return lowestCommonAncestor( root.left,  p,  q);

        
    }
}
