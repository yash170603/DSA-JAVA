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
    int [] height= new int [100001];
    int [] level= new int [ 100001];
    int [] maxHeightLevel = new int[100001];
    int [] secondmaxHeightLevel = new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        solve(  root, 0);
        int n= queries.length;
        int [] ans = new int [n];
        int index =0;
        for( int node: queries){
              int nodeLevel= level[node];
              int rest = (height[node] == maxHeightLevel[nodeLevel]?secondmaxHeightLevel[nodeLevel]:maxHeightLevel[nodeLevel]);
             
             
           ans[index]= nodeLevel+rest-1;
           index++;

        }

        return ans;
    }

    public int solve( TreeNode root, int lev){
       
       if( root == null) return 0;
        
        level[root.val]=lev;

        height[root.val]= Math.max( solve(root.left,lev+1), solve(root.right,lev+1))+1;

        if( height[root.val]> maxHeightLevel[lev]){
            secondmaxHeightLevel[lev]=maxHeightLevel[lev];
            maxHeightLevel[lev]=height[root.val];
        }
        else if( height[root.val]>secondmaxHeightLevel[lev]){
            secondmaxHeightLevel[lev]=height[root.val];
        }

        return height[root.val];

    }
}
