class Solution {
    public int minimumMountainRemovals(int[] nums) {
        

        int n = nums.length;
        int [] lis = new int [n];
        int [] lds = new int [n];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);

        for( int i=0;i<n;i++){
            for( int j=0;j<i;j++){
                 if( nums[i]>nums[j]){
                     lis[i]= Math.max(lis[i],lis[j]+1);
                 }
            }
        }
        for( int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if( nums[i]>nums[j]){
                    lds[i]=Math.max(lds[i],lds[j]+1);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for( int peak =1;peak<n-1;peak++){// o and n-1th index cant be peak
            // atleast 2 elemenets should be there in each indexs lis and lds, as lis and lds contain the index itself as peak
            if( lis[peak]>1 && lds[peak]>1){
                int tot = lis[peak]+lds[peak]-1;
                ans=Math.min(ans, n-tot);
            }
        }

        return ans;
    }
}
