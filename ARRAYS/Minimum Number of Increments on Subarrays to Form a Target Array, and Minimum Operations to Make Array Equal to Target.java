Minimum Number of Increments on Subarrays to Form a Target Array

  - almost same , subproblem for the nest one
  class Solution {
    public int minNumberOperations(int[] targett) {
   
   List<Integer> target= new ArrayList<>();
   for( int x:targett){
     target.add(x);
   }
         for (int i = 0; i < target.size(); i++) {
            target.set(i, Math.abs(target.get(i)));
        }

        int totalMinOperations = target.get(0);
        int operationsWeDidEarlier = target.get(0);

        for (int i = 1; i < target.size(); i++) {
            if (target.get(i) <= operationsWeDidEarlier) {
                operationsWeDidEarlier = target.get(i);
            } else {
                totalMinOperations += target.get(i) - operationsWeDidEarlier;
                operationsWeDidEarlier = target.get(i);
            }
        }
        return totalMinOperations;
    }
}




. Minimum Operations to Make Array Equal to Target

  extension form above
  import java.util.*;

class Solution {
    public long f(List<Integer> target) {
        for (int i = 0; i < target.size(); i++) {
            target.set(i, Math.abs(target.get(i)));
        }

        int totalMinOperations = target.get(0);
        int operationsWeDidEarlier = target.get(0);

        for (int i = 1; i < target.size(); i++) {
            if (target.get(i) <= operationsWeDidEarlier) {
                operationsWeDidEarlier = target.get(i);
            } else {
                totalMinOperations += target.get(i) - operationsWeDidEarlier;
                operationsWeDidEarlier = target.get(i);
            }
        }
        return totalMinOperations;
    }

    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = target[i] - nums[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (dif[i] == 0) {
                continue;
            }

            List<Integer> pre = new ArrayList<>();
            pre.add(dif[i]);
            int ind = n;
            for (int j = i + 1; j < n; j++) {
                if (dif[i] < 0 && dif[j] < 0) {
                    pre.add(dif[j]);
                } else if (dif[i] > 0 && dif[j] > 0) {
                    pre.add(dif[j]);
                } else {
                    ind = j;
                    break;
                }
            }
            ans += f(pre);
            i = ind - 1;
        }
        return ans;
    }

    
}
