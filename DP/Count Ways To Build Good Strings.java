class Solution {
    int ans;
 
    int mod=(int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        ans = 0;
         HashMap<Integer,Integer> map= new HashMap<>();
        ans=solve(high, low, 0,map,  zero,one);
        return ans;
    }

    public int solve(int high, int low, int curr,  HashMap<Integer,Integer> map, int zero, int one) {
        if (curr > high) return 0; // Base case: Stop when `curr` exceeds `high`.
         int thisAns=0;
        if (curr >= low && curr<=high) {  
            thisAns++;
        }
        if( map.get(curr)!=null)return map.get(curr);
        thisAns += solve(high, low, curr + zero,map ,zero,one); 
       thisAns+= solve(high, low, curr + one,map,zero,one); 
       map.put(curr,thisAns%mod);
       return map.get(curr);
    }
}
