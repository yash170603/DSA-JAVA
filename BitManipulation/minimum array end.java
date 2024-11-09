class Solution {
    public long minEnd(int n, int x) {
         long num = x;

        for (int i = 1; i < n; i++) {
            num = (num + 1) | x;
        }

        return num;
        }
}..


// my solution, 
failed on n=1, x=1
  class Solution {
    public long minEnd(int n, int x) {
       int pos = 0; 
        long result = x;
        
        for (int i = 0; i < n-1; i++) {
            while ((x & (1L << pos)) != 0) {
                pos++;
            }
            result = x | (1L << pos);
            pos++;  
        }
        
        return result;
        }
}
