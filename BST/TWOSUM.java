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
//  import java.util.Stack;
// class BSTiterator1
// {
//    // TreeNode temp;
//     Stack<TreeNode> s = new Stack<TreeNode>();
//     boolean reverse;
//     public  BSTiterator1(TreeNode root, boolean b)
//     {
//       // this.temp = root;
//         pushall(root);
//         this.reverse = b;
//     }
//     public int next()
//     {
//         TreeNode temp = s.pop();
//         int ans = temp.val;
//         if(reverse == false)
//         {
//                 //if(temp.right != null)
//         pushall(temp.right);
//         }
//         else
//         pushall(temp.left);      
//         return ans;
//     }
//     // public boolean hasNext()
//     // {
//     //     boolean g = false;
//     //     if(  s.isEmpty() != true)
//     //       g = true;
//     //       return g;
//     // }
//     public void pushall(TreeNode root)
//     {
//         while(root != null)
//         {
//             s.push(root);
//             if(reverse == false)
//             root = root.left;
//             else
//             root = root.right;
//         }
//     }
// }
// class Solution {
//     public boolean findTarget(TreeNode root, int k) 
//     {       
//         if(root == null)
//         return false;
//          BSTiterator1 a = new  BSTiterator1(root, false);
//           BSTiterator1 b= new  BSTiterator1(root, true);

//              int v = a.next();
//              int y = b.next();

//           while(v<y)
//           {
//               if(v+ y ==  k)
//               {
//                   return true;
//                 //  break;
//               }

//               if(v+y > k)
//               {
//                   y = b.next();
//               }
//               else
//               v = a.next();
//           }

//           return false;
//     }
// }
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    
    public BSTIterator(TreeNode root,boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        if(!reverse) pushAll(node.right);  
        else pushAll(node.left);  
        return node.val;
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            st.push(node); 
            if(!reverse) node = node.left;
            else node = node.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        // l gives the elements from very smallest one to further greater
        BSTIterator l = new BSTIterator(root,false);
        // r gives the elements from very largest one to further smaller.
        BSTIterator r = new BSTIterator(root,true);
        
        int i = l.next();
        int j = r.next();
        // Now simple use 2 pointer in a sorted array to find the sum !
        while(i<j){
            if(i+j == k) return true;
            if(i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
