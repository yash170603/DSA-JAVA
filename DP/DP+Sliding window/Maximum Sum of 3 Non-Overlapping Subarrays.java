class Solution {
    private int[] nums;
    private int k;
    private int[] kSums;
    private Map<String, Integer> dp;
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        this.dp = new HashMap<>();
        
        // Preprocessing: Calculate k-sized window sums
        kSums = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        kSums[0] = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            kSums[i - k + 1] = sum;
        }
        
        return getIndices();
    }
    
    private int getMaxSum(int i, int cnt) {
        if (cnt == 3 || i > nums.length - k) {
            return 0;
        }
        
        String key = i + "," + cnt;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        // Include current window
        int include = kSums[i] + getMaxSum(i + k, cnt + 1);
        // Skip current window
        int skip = getMaxSum(i + 1, cnt);
        
        dp.put(key, Math.max(include, skip));
        return dp.get(key);
    }
    
    private int[] getIndices() {
        List<Integer> indices = new ArrayList<>();
        int i = 0;
        
        while (i <= nums.length - k && indices.size() < 3) {
            // Include current window
            int include = kSums[i] + getMaxSum(i + k, indices.size() + 1);
            // Skip current window
            int skip = getMaxSum(i + 1, indices.size());
            
            if (include >= skip) {
                indices.add(i);
                i += k;
            } else {
                i += 1;
            }
        }
        
        // Convert List<Integer> to int[]
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}
