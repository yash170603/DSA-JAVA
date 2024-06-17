class Solution {
    public boolean judgeSquareSum(int c) {
        
        long left =0;
        long right = (int)Math.sqrt(c);   range will be from zero to under-root c
        while( left<=right)
        {
            long val = left*left+right*right;
            if( val==c)
            return true;
            if( val<c)
            {
                left++;
            }
            else
            right--;
        }
        return false;
    }
}
