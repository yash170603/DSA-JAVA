class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != 
        postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
    int ps, int pe,HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps,
        ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, 
        ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}

//2nd

import java.util.HashMap;

class Solution {
    private int postorderIdx;

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        int rootValue = postorder[postorderIdx];
        TreeNode root = new TreeNode(rootValue);
        postorderIdx--;

        int inorderIdx = map.get(rootValue);

        root.right = buildTreeHelper(inorder, postorder, map, inorderIdx + 1, right);
        root.left = buildTreeHelper(inorder, postorder, map, left, inorderIdx - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        postorderIdx = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, map, 0, len - 1);
    }
}

