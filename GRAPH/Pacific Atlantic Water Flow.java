//BruteForce
class Solution {
    
    int m,n;
    int[][] matrix;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return result;
        m=matrix.length;
        n=matrix[0].length;
        this.matrix=matrix;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
				//If both flags are true, add in result
                if(reachPacific(i,j) && reachAtlantic(i,j)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    boolean reachPacific(int r,int c){
        
        if(r==0 || c==0) return true;
        if(matrix[r][c]==-1) return false;
        int val=matrix[r][c];
        matrix[r][c]=-1;
        boolean flag=false;
		    
        //Call DFS in all 4 Directions 
        if(matrix[r-1][c]<=val){
            flag=reachPacific(r-1,c);
        }
        
        if(!flag && matrix[r][c-1]<=val){
            flag = reachPacific(r,c-1);
        }
        
        if(!flag && c+1<n && matrix[r][c+1]<=val){
            flag = reachPacific(r,c+1);
        }
        
        if(!flag && r+1<m && matrix[r+1][c]<=val){
            flag = reachPacific(r+1,c);
        }
        matrix[r][c]=val;
        return flag;
    }
    
    boolean reachAtlantic(int r,int c){
        if(r==m-1 || c==n-1) return true;
        if(matrix[r][c]==-1) return false;
        int val=matrix[r][c];
        matrix[r][c]=-1;
        boolean flag=false;
		    
        //Call DFS in all 4 Directions
        if(matrix[r+1][c]<=val){
            flag=reachAtlantic(r+1,c);
        }
        if(!flag &&  matrix[r][c+1]<=val){
            flag = reachAtlantic(r,c+1);
        }
        if(!flag && c-1>=0 &&  matrix[r][c-1]<=val){
            flag = reachAtlantic(r,c-1);
        }
        if(!flag &&  r-1>=0 && matrix[r-1][c]<=val){
            flag = reachAtlantic(r-1,c);
        }
        matrix[r][c]=val;
        return flag;
    }
}

//Optimized

class Solution {
    int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return res;
        
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        //DFS
        for(int i = 0; i < col; i++){
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, row-1, i, Integer.MIN_VALUE, atlantic);
        }
        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, col-1, Integer.MIN_VALUE, atlantic);
        }
        
        //preparing the result
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
        if(matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for(int[] d : dir){
            dfs(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
        }
        
    }
}
