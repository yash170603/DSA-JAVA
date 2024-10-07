class Solution {
    public int[] productExceptSelf(int[] nums) {
           int n = nums.length;
           int [] ans = new int [n];


           int prev =1;
           for( int i =0;i<n;i++){
                ans[i]= prev;
                prev = prev*nums[i];  // is index se previously kitna prodeuct aaya hai
           }

            prev=1;
           for(int j=n-1;j>=0;j--){
                 ans[j]= ans[j]*prev;    //index--->n-1,, stores 0*1*2 -----(n-2) elements tak ka product.  because we dont need the n-1th element ATQ.  now consideirng n-1 k aage bhi array oti toh uska prod bhi hoga, and n-1 of ans already soredresu till n-2 (includive), so dono ka multiply kr do
                 prev*=nums[j];

           }

           return ans;
    }
}
