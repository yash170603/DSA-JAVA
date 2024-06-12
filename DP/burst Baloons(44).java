class Solution {
    int dp [][];

    public int maxCoins(int[] nums) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        for( int g:nums)
        {
            x.add(g);
        }
        x.add(1);
        dp= new int [x.size()][x.size()];
        for(int arr[]:dp)
        {
            Arrays.fill( arr,-1);
        }

        return solve( 1, x.size()-2,x);
    }


    public int solve( int i,int j, ArrayList<Integer> x)
    {
        if( i>j)
        return 0;
        if( dp[i][j] !=-1)
        return dp[i][j];

        int coins = Integer.MIN_VALUE;
        for ( int a=i;a<=j;a++)
        {
            int max =  (x.get(i-1)*x.get(a)*x.get(j+1))+ solve(i,a-1,x)+solve(a+1,j,x);
            coins = Math.max(coins,max);
        }
      return dp[i][j]=coins;
    }
}
