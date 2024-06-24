// brute force
class Solution {
    public int minKBitFlips(int[] nums, int k) {
         
            int n = nums.length;
            int flips =0;


            for( int  i=0;i<n;i++)
            {
                if( nums[i] ==0)
                {
                    for( int j = i;j<= i+k-1;j++)
                    {
                        if( i+k-1>=n)
                        return -1;
                        nums[j]= (nums[j]==0)?1:0;
                    }
                    flips++;
                }
            }

            return flips;
    }
}



// optimal;
0->even flips=0
0-> odd flips =1
1->even flips =1
1->odd flips=0

// the thing is thaht the size of q will represnt the no of  onversions till bit index(element ) in q
//   pick the number
//   check if no of flips till thath index  and element at that index
//   if no of inversions is even, i.e ( no of inversions %2 == 0) and bit == 0 ,
//   which means we have to flip the  the number,
//   if the nums[i] was 1 and no of flips%2 ==0 (1->even flips =1) no need to flip,
//   similarly vice versa
  //  the queue store the last index till all bits were flipped ,
  // if q stores only 2
  // means all emelents till index 2 were flipped once,

  // lets say original array was 0,1,1,1,1,0 and k=3
  //  at o index was 0, needs flip, 
  // q will store 2,,  temp array beomes 1,0,0,1,1,0
  // and now i moves to index 1, index 1 =0,(after conversion) and q size is 1, and 1 < q.peek()( no polling required) 
  // meaning there was 1 inversion till or beyond index 1, and original array had 1 as elemet at index 1
  // meaning finally original was 1 , on no of odd conversions(size of q here, which  is 1) the original 1 was set to 0 now in converted array and hence needs a flips,
  //so the last index of 
  // new window will be added to queue, and no of flips will be increased,
  // when i exceeds the front element of q, it just pops it out.

  class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int flips =0;
        for( int i =0;i<n;i++)
        {
            if( !q.isEmpty() &&  q.peek()< i)
            {
                q.poll();
            }      
                if( q.size() %2 == nums[i])
                {
                    if( i+k-1>=n)
                    return -1;
                    q.offer(i+k-1);
                    flips++;
                }     
        }
        return flips;
    }
}
