class Solution {
    public long maxSum(List<Integer> num, int m, int k) {
        int n = num.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = num.get(i);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        long curr = 0, ans = 0;

        while (i < n) {
          
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            curr += nums[i];
 
            if (i - j + 1 == k) {
          
                if (map.size() >= m) {
                    ans = Math.max(ans, curr);
                }
   
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);  
                }
                curr -= nums[j];
                j++;
            }
            i++;
        }

        return ans;
    }
}
