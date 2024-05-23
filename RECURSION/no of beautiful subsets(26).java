// 1 my code beates only 25
class Solution {
    int k;
    public int beautifulSubsets(int[] nums, int t) {
        
        Arrays.sort(nums);
        k=t;
        List<Integer> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        dfs(0,nums,a,b);

        return b.size()-1;
    }
    public void dfs( int index, int [] nums, List<Integer> a, List<List<Integer>> b)
    {
        if( index == nums.length)
        {
            b.add( new ArrayList<>(a));
            return;
        }
        boolean flag = false;
      if(!a.contains(nums[index]-k))
      {
        flag=true;
        a.add(nums[index]);
        dfs(index+1,nums,a,b);
      }
      if( flag == true && a.size() >0)
      {
        a.remove(a.size()-1);
      }

      dfs(index+1,nums,a,b);

      return ;

    }
}



// gpt code beatts 53 percent
// trick was to only pick elements which will make the subset good
class Solution {
    int k;
    public int beautifulSubsets(int[] nums, int t) {
         k = t;
        Arrays.sort(nums);  // Sorting to handle elements in order and simplify subset creation
        List<Integer> currentSubset = new ArrayList<>();
        Set<Integer> elementSet = new HashSet<>();
        return dfs(0, nums, currentSubset, elementSet) - 1;  //
    }
    private int dfs(int index, int[] nums, List<Integer> currentSubset, Set<Integer> elementSet) {
        if (index == nums.length) {
            return 1;  // Count the current subset as a valid subset
        }
        
        int count = 0;
        
        // Option 1: Exclude the current element
        count += dfs(index + 1, nums, currentSubset, elementSet);
        
        // Option 2: Include the current element if it maintains the "beautiful" condition
        if (!elementSet.contains(nums[index] - k)) {
            currentSubset.add(nums[index]);
            elementSet.add(nums[index]);
            count += dfs(index + 1, nums, currentSubset, elementSet);
            // Backtrack: remove the current element from subset and set
            currentSubset.remove(currentSubset.size() - 1);
            elementSet.remove(nums[index]);
        }
        
        return count;
    }
}


// using dp, idk wtf is going on
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);

        int res = 1, prev = 0, prevPrev = 0;

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            if (m.containsKey(cur - k)) continue;
            
            prev = 0;

            while (m.containsKey(cur)) {
                prevPrev = prev;
                prev = ((1 << m.get(cur)) - 1) * res;
                res += prevPrev;
                cur += k;
            }
            res += prev;
        }
        return res - 1;
    }
}
