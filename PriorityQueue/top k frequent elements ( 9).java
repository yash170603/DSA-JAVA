// pq
the goal was KEEP THE PQ SIZE ONLY TO K, AND POP THE PEEK WHICH WILL HAVE SMALLEST FREQUENCY WHEN PQ SIZE INCREASES BY K.
  BY THIS WAY PQ WILL AYAS CONTIANS K ELEMENTS.
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {  
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>( (a,b)->(a[1]-b[1]));
        for( int x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int val= entry.getKey();
            int freq= entry.getValue();
            int ar[]= new int[2];
            ar[0]=val;
            ar[1]=freq;
            pq.offer(ar);
            while( pq.size()>k)
            { 
               pq.poll();
            }
        }
        int ans[]=new int[k];
        for( int i=0;i<k;i++) 
        {
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}




./// BUCKET SORT
THE GOAL WAS TO  MAKE A LIST<LIST<INTEGER>>
  WHERE THE LIST(INNER LIST) STORED AT  LIST.GET(INDEX) (OUTERLIST), CONTAINS ALL THE ELEMENTS WHICH HAVE FREQUENCY AS INDEX
  AS EG - MAP HAS 
  1->3
  2->2
  3->1

  STORE IT AS 
  LIST.GET (3) -{1}
LIST.GET(2)-{2}
lIST.GET(1)-{3}.,,, CAN HAVE MANY MORE ELEMENTS

  TRAVERSE THE LIST<LIST<INTEGER>> FROM BACK TILL U GET K VALUES WHICH HAVE NON EMPTY LISTS STORED AT THE INDEX'
  REMEMEBER THE INDEX IS THE FREQUENCY AND LIST ITEMS ARE THE ITEMS HAVING FREQUENCY AS THE INDEX.


  import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create an array of lists where the index represents the frequency
        List<Integer>[] bucket = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }
        
        // Step 3: Populate the buckets with elements based on their frequency
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            bucket[frequency].add(element);
        }
        
        // Step 4: Iterate from the highest frequency bucket to the lowest to gather the top K frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0 && result.size() < k; i--) {
            if (!bucket[i].isEmpty()) {
                result.addAll(bucket[i]);
            }
        }
        
        // Ensure we only return k elements
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(solution.topKFrequent(nums, k)); // Output: [1, 2]
    }
}
