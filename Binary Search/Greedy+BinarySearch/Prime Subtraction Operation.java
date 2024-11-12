import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean primeSubOperation(int[] nums) {
    
        if (isSortedAndUnique(nums)) {
            return true;
        }
     
        List<Integer> primes = sieveOfEratosthenes(1000);
  
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
               
                int ind = binarySearch(primes, nums[i]);
                if (ind == 0) {
                    continue;
                }   
                nums[i] -= primes.get(ind - 1);
            } else {
       
                if (nums[i] <= nums[i - 1]) {
                    return false;
                }
                int val = nums[i] - nums[i - 1];
                int ind = binarySearch(primes, val);
                if (ind == 0) {
                    continue;
                }
                nums[i] -= primes.get(ind - 1);
            }
        }
        
        return isSorted(nums);
    }
    
    private boolean isSortedAndUnique(int[] nums) {
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> sieveOfEratosthenes(int limit) {

        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        
        // for (int i = 2; i <= limit; i++) {
        //     isPrime[i] = true;
        // }
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        
        for (int num = 2;(long) num * num <= limit; num++) {
            if (isPrime[num]) {
                for (int multiple = num * num; multiple <= limit; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }
        
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

    private boolean isSorted(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
