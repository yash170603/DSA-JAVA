// two pointer
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int i= 0;
        int j= n-1;
        int []ans= new int[2];

        while(i<j){
            int sum= numbers[i]+numbers[j];
            if( sum==target){
                ans[0]=i;
                ans[1]=j;
                break;
            }
            else if( sum< target){
                i++;
            }
            else 
            j--;
        }
        
        ans[0]+=1;
        ans[1]+=1;
        return ans;


    }
}

// binary search
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, i + 1, n - 1, complement);

            if (index != -1) {
                return new int[]{i + 1, index + 1}; // Return 1-based indices
            }
        }

        // If no solution found (though the problem guarantees one solution)
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] numbers, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
