//BRUTEFORCE Approach

import java.util.*;
public class threesum2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);

        int nums [] = {-1,0,1,2,-1,-4};
    
      List<List<Integer>> result =  THREESUMS(nums);
      HashSet< List<Integer>> h = new HashSet<>();

    for(List<Integer> f : result)
    {
        h.add(f);
    }
       
     for(List<Integer> g : h)
    {
        System.out.println(g);
    }
    }

    public static  List<List<Integer>> THREESUMS(int[] nums)
    {
       
       Arrays.sort(nums);
       int v = nums.length-1;
       List<List<Integer>> x = new ArrayList<>();
      List<Integer> local = new ArrayList<>();
   

       for(int i =0; i<=v;i++)
       {
        for(int j= i+1;j<=v;j++)
        {
            for(int k= j+1;k<=v;k++)
            {
               if(nums[i] + nums[j] + nums[k] == 0)
               {
                local = Arrays.asList(nums[i], nums[j], nums[k]);
                x.add(local);
               }

              

            }
        }

        
       }

    
return x;



   }
}


// 2pointer
class Solution {
    public List<List<Integer>> threeSum(int[] nums)
     {
        
        int target = 0;
        Arrays.sort(nums);
        List<Integer> s = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;

    }
}

