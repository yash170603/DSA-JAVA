//without lca class Solution {
    StringBuilder s;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null)
            return "";
        
        s = new StringBuilder();
        String rootTosrc = "", rootTodest = "";
        
        dfs(root, startValue);
        rootTosrc = s.toString();
        s.setLength(0);
        
        dfs(root, destValue);
        rootTodest = s.toString();
        
        // If rootTodest is empty, we return a special case
        // if (rootTodest.isEmpty()) {
        //     return "";
        // }
        
        int i;
        for (i = 0; i < rootTosrc.length() && i < rootTodest.length(); i++) {
            if (rootTosrc.charAt(i) != rootTodest.charAt(i)) {
                break;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int j = i; j < rootTosrc.length(); j++) {
            ans.append('U');
        }
        
        String left = rootTodest.substring(i, rootTodest.length());
        ans.append(left);
        
        return ans.toString();
    }

    public boolean dfs(TreeNode root, int target) {
        if (root == null) 
            return false;
        
        if (root.val == target) 
            return true;
        
        s.append('L');
        if (dfs(root.left, target)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        s.append('R');
        if (dfs(root.right, target)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        return false;
    }
}
.// with lca was same, just  concatenate both strings, and start trversal from lcaa
