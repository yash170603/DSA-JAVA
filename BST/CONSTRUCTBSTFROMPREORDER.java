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
    int index = 0;
    private TreeNode bstFromPreorder1(int[] preorder, int bound) {
        // Check if we have reached the end of the array or if the current value is greater than the bound
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        // Create a new node with the current value
        TreeNode root = new TreeNode(preorder[index++]);

        // Recursively construct the left and right subtrees
        root.left = bstFromPreorder1(preorder, root.val);
        root.right = bstFromPreorder1(preorder, bound);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //first we calle find solution methhod for solve that program recurssively .
        return bstFromPreorder1(preorder,Integer.MAX_VALUE);
    }
}









//

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
    int index = 0;
    public TreeNode findSolution(int[] pre,TreeNode root,int min,int max){  
        //base case
        if(index>=pre.length){
            return null;
        }
        //check the array value is outside of range or not ..
        if(pre[index]<min || pre[index]>max){
            return null;
        }
        //if the array value in the range then put logic and create tree
        int temp = pre[index++];
        root = new TreeNode(temp);
        root.left = findSolution(pre,root.left,min,temp);
        root.right = findSolution(pre,root.right,temp,max);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //first we calle find solution methhod for solve that program recurssively .
        return findSolution(preorder,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
