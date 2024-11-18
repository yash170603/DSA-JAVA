class Solution {
    public char kthCharacter(long k, int[] nums) {
        if( k ==1){
            return 'a';
        }
        long currLength = 1;
        long opType=0;
        int n=nums.length;
        long newk=k;
        for(int i =0;i<n;i++){
            currLength*=2; 
             opType=nums[i];
            if(currLength>=k){
                 k=k-currLength/2;
                 break;
            }
        }
        char ans = kthCharacter(k,nums);
        if( opType==0) return ans;
        if( ans=='z') return 'a';
        return (char)(ans+1);

    }
}
