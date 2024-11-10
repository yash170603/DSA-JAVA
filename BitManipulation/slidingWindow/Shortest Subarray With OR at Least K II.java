class Solution {
     int [] arr = new int[32];
    public int minimumSubarrayLength(int[] nums, int k) {
        int i=0,j=0,n=nums.length,ans=Integer.MAX_VALUE;
       while( i< n){
          update(nums[i],1);
          while( j<=i &&  newNumber()>=k){
             ans=Math.min(ans,i-j+1);
             update(nums[j],-1);
             j++;
          }
          i++;
       }
         return  ans==Integer.MAX_VALUE?-1:ans;
    }

    public void update(int val, int margin){
        
        for( int bit=0;bit<32;bit++){
             int thisBit = (val>>bit)&1;
             if( thisBit==1){
                arr[bit]=arr[bit]+margin;
             }
        }
    }

    public  int newNumber( ){
          int num=0;
          for(int bit =0;bit<32;bit++){
              if(arr[bit]>0){
                 num|=(1<<bit);
              }
          }

          return num;
    }
}
