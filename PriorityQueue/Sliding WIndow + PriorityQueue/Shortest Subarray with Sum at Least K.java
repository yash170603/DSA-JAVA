// gives tle tho,,   solution is DEQUE+sliding window, solution in the folder
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int n=nums.length;
        for( int i =0;i<n;i++){
              pq.offer( new int[]{nums[i],i,i});
        }

        int ans=Integer.MAX_VALUE;
          while(! pq.isEmpty()){
                int []x= pq.poll();
                if(x[0]>=k){
                   ans= Math.min(ans, x[2]-x[1]+1);
                }
                if(ans ==1) break;

                if( x[2]+1<n){
                    pq.offer( new int []{ x[0]+nums[x[2]+1],x[1],x[2]+1 }    );
                }
          } 

          return ans==Integer.MAX_VALUE?-1:ans;
    }
}
