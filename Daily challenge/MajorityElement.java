// my method
class Solution {
    public List<Integer> majorityElement(int[] nums)
     {
         
           int n= nums.length;
          List<Integer> ec1 = new ArrayList<Integer>();
          List<Integer> ec2 = new ArrayList<Integer>();
          List<Integer> ans = new ArrayList<Integer>();
           List<Integer> mans = new ArrayList<Integer>();
              List<Integer> yash = new ArrayList<Integer>();
           HashSet<Integer> b = new HashSet<>();

          if(n == 1)
          {
              ec1.add(nums[0]);
              return ec1;
          }
            

          if(n== 2)
        {
            
            if(nums[0] == nums[1])
            {
                yash.add(nums[0]);
                 return yash;
            }
            ec2.add(nums[0]);
            ec2.add(nums[1]);
            return ec2;
        }
        HashMap<Integer,Integer> a = new HashMap<>();
       
        
      for (int k : nums) {
            int l = a.getOrDefault(k, 0);
            a.put(k, l + 1);
        }
 

        
      for(int q: nums)
      {
        int z = a.get(q);
        if(z >(n/3))
        {
            ans.add(q);
        }
      }

          for(int t: ans)
          {
             b.add(t);
          }
          for(int T: b)
          {
             mans.add(T);
          }


       return mans;


    }
}



// lc solution
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Create a frequency map to store the count of each element
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        
        // Iterate through the input array to count element occurrences
        for (int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;
        
        // Iterate through the frequency map to identify majority elements
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            
            // Check if the element count is greater than the threshold
            if (count > threshold) {
                majorityElements.add(element);
            }
        }
        
        return majorityElements;
    }
}
