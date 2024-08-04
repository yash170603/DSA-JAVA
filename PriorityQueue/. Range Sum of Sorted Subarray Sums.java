class Solution {
    int mod= 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for( int i = 0; i< n;i++){
            pq.offer( new int[]{nums[i],i});
        }
        int ans =0;

       for(int i=1;i<=right;i++){
            int poped[]= pq.poll();
            int value=poped[0];
            int indexEnding=poped[1];
            if( i>=left){
                ans= (ans+value)%mod;
            }
            if( indexEnding< n-1){
                pq.offer( new int []{value+nums[indexEnding+1],indexEnding+1});
            }
        }

     return ans%mod;

    }
}
