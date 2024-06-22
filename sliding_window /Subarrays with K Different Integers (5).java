// brute
class Solution {
    public int subarraysWithKDistinct(int[] nums, int v) 
    {
          if( v ==0)
          {
            return 0;
          }

          return solve(nums,v) - solve(nums,v-1);
    }

    public int solve(int [] nums, int k)
    {
             HashMap<Integer,Integer> x = new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        int n = nums.length;

        while( j<n)
        {
            x.put(nums[j],x.getOrDefault(nums[j],0)+1);

            while(x.size() > k)
            {
                if( (x.get(nums[i]) != 0 )|| (x.get(nums[i]) != null))
                {
                     x.put(nums[i],x.get(nums[i])-1);

                 if( x.get(nums[i]) ==0 )
                 {
                    x.remove(nums[i]);
                 }
                }
                 i++;


            }
           
            ans += (j-i+1);
            j++;
        }

        return ans;
    }
}


//3 ptr'
class Solution {
    public int subarraysWithKDistinct(int[] nums, int v) 
    {
          if( v ==0)
          {
            return 0;
          }

          return solve(nums,v) - solve(nums,v-1);
    }

    public int solve(int [] nums, int k)
    {
             HashMap<Integer,Integer> x = new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        int n = nums.length;

        while( j<n)
        {
            x.put(nums[j],x.getOrDefault(nums[j],0)+1);

            while(x.size() > k)
            {
                if( (x.get(nums[i]) != 0 ))
                {
                     x.put(nums[i],x.get(nums[i])-1);

                 if( x.get(nums[i]) ==0 )
                 {
                    x.remove(nums[i]);
                 }
                }
                 i++;


            }
           
            ans += (j-i+1);
            j++;
        }

        return ans;
    }
}
