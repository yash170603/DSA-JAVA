
    import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
 class permute 
{
         public static void main(String args [])
         {
                   int nums [] = {1};
                   List<List<Integer>> g = permuteUnique(nums);
                   for(List<Integer> h: g)
                       {
                        System.out.print(h);
                       }
                   
         }

    public  static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        backtrack(res, nums, 0, set);
        return res;
    }

    public  static void backtrack(List<List<Integer>> res, int[] nums, int index, HashSet<List<Integer>> set) {
        if (index == nums.length) {
            List<Integer> current = toList(nums);
            if (!set.contains(current)) {
                res.add(current);
                set.add(current);
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(index, i, nums);
                backtrack(res, nums, index + 1, set);
                swap(index, i, nums);
            }
        }
    }

    public static  void swap(int m, int n, int[] nums) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public  static List<Integer> toList(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int n : nums) {
            l.add(n);
        }
        return l;
    }
}

