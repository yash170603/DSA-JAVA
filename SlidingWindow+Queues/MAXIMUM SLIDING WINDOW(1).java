//return an array with each index as the maximum elemnt in the given winfow size


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans= new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

      // iterating through the first window,  and getting the maxiumu element index
        for( int i=0;i<k-1;i++)
        {
           if( q.isEmpty())
           {
            q.addLast(i);
           }
           else
           {
            while( !q.isEmpty() && nums[i]> nums[q.getLast()])
            {
                q.removeLast();
            }
            q.addLast(i);
           }

        }
     
      // goal is to store 1max,2max,3max elemet at once
       // j starts from j= k-1;
      // remeber there is a window tht starts from idex 1 to k-1
      // in which max element from 0,1,2 has already been stored in deque
      // so starting j from k -1 represnets a window from 1,2,3(k-1), 
      // max from 0,1,2, already in q, and checking for 1,2,3, just checking for 3 as if andy of 1,2 is biggest in 1,2,3 its already stored in q
    
        int index=0;
        for( int j = k-1;j<n;j++)
        {
          while( !q.isEmpty() && nums[j]> nums[q.getLast()])
            {
                q.removeLast();     //pop the smaller elements from back, and add the current
            }
            q.addLast(j);
           if( !q.isEmpty() &&  q.getFirst()<=(j-k))
            {
                q.removeFirst();  // pop the elements which are before the staeting index of the window
            }
            ans.add(nums[q.getFirst()]);         
        }
      int a[]= new int[ans.size()];
  
      for( int s:ans)
      {
        a[index]=s;
        index++;
      }
        return a;
    }
}
