class Solution {
    public int nthUglyNumber(int n) {
        if( n==1)
        return 1;

        PriorityQueue<Long> min= new PriorityQueue<>();
        min.offer(1L);
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        long ugly=1;
        int arr[]= {2,3,5};

        for( int i=1;i<=n;i++){
            ugly=min.poll();
             for( int a:arr){
                if(set.add(ugly*a)){
                    min.offer(ugly*a);
                }
             }
        }

        return (int) ugly;
    }
}
