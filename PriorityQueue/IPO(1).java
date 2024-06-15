class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = profits.length;
        int arr [][]= new int [n][2];
        for( int i =0;i<n;i++)
        {
            arr[i][0]= capital[i];
            arr[i][1]= profits[i];
        }

        // Arrays.sort(arr, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return Integer.compare(a[0], b[0]);
        //     }
        // });
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int a=0;
        while( k-->0)
        {
            while( a<n && arr[a][0]<=w)
            {
                pq.offer( arr[a][1]);
                a++;
            }
            if( pq.isEmpty())
            {
                break;
            }
            w+=pq.poll();
        }
       
       return w;
    }
}


