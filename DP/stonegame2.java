// class Solution {
//     int [][][]dp= new int[2][101][101];
//     int n;
//     public int stoneGameII(int[] piles) {
//           n=piles.length;
//           for(int ar[][]:dp){
//             for( int a[]:ar){
//                 Arrays.fill(a,-1);
//             }
//           }

//           return dfs(piles,0,0,1);
//     }  

//     //ALICE->0

//     public int dfs( int []piles, int index, int person, int M){
//         if( index>=n)
//         return 0;

//         if( dp[person][index][M] !=-1){
//             return dp[person][index][M];
//         }
//         int ans= (person==0)?-1:Integer.MAX_VALUE;
//          int stones=0;
//             for( int x=1;x<=Math.min(n-index,2*M);x++){
//                 stones+=piles[x+index-1];
//                 if(person==0)
//                 ans= Math.max(ans, stones+ dfs(piles, index+x,0,Math.max(M,x)));
//                 else
//                 ans=Math.min(ans,dfs(piles,index+x,1,Math.max(M,x)));
//             }

//             return dp[person][index][M]=ans;
//     }
// }
class Solution {
    private int n;
    private int[][][] t = new int[2][101][101]; // t[2][n+1][n+1] ~ O(n^3)
    
    private int solveForAlice(int[] piles, int person, int i, int M) {
        if (i >= n) {
            return 0;
        }
        
        if (t[person][i][M] != -1) {
            return t[person][i][M];
        }
        
        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        
        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];
            
            if (person == 1) { // Alice
                result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x)));
            } else { // Bob
                result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x)));
            }
        }
        
        return t[person][i][M] = result;
    }
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        
        for (int[][] arr2D : t) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        return solveForAlice(piles, 1, 0, 1);
    }
}
