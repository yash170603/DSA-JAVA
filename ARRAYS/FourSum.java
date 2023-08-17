// brute force works for 98.29 percent caes. Diid it my self
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int v = nums.length;
     List<List<Integer>> h = new ArrayList<>();
     HashSet<List<Integer>> a = new HashSet<>();
      List<List<Integer>> b = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            for(int j =i+1;j<v;j++)
            {
                for(int k = j+1; k<v;k++)
                {
                    for(int l = k+1; l<v; l++)
                    {
                        if( nums[i] + nums[j] + nums[k] + nums[l] == target)
                        {
                            List<Integer> x = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                               h.add(x);
                        }
                    }
                }
            }
        }

        for(List<Integer> p : h )
        {
            a.add(p);
        }

       
 for( List<Integer> s : a )
        {
            b.add(s);
        }

        return b;

    }
}






// 2 pointer
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        output.addAll(s);
        return output;
    }
}

