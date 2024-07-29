class Solution {
    public int nonSpecialCount(int l, int r) {
         int maxLimit = (int) Math.sqrt(r);
        boolean[] isPrime = sieveOfEratosthenes(maxLimit);
        
        // Count special numbers in range [l, r]
        int specialCount = 0;
        for (int i = 2; i <= maxLimit; i++) {
            if (isPrime[i]) {
                int square = i * i;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }
        
        // Total numbers in range [l, r]
        int totalCount = r - l + 1;
        
        // Non-special numbers count
        return totalCount - specialCount;
    }
      public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
