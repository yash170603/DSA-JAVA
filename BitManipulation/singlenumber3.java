class Solution {
    public int[] singleNumber(int[] nums) {
        int totxor =0;
        for(int u:nums)
        {
            totxor = totxor^u;
        }
        int mask = totxor & (-totxor);
  

    int grpa=0;
    int grpb=0;
    int ans []= new int [2];

    for( int p:nums)
    {
        if( (p & mask) ==0)
        {
            grpa= grpa^p;
        }
      else
        grpb=grpb^p;
    }
    ans[0]=grpa;
    ans[1] =grpb;
    return ans;  // new int []{grpa,grpb}

    }
}
