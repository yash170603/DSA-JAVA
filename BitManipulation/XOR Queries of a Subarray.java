class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n= queries.length;
        int [] ans = new int[n];
        int [] prefix = new int [arr.length];
        prefix[0]=arr[0];

        for( int i =1;i<arr.length;i++){
            prefix[i]=arr[i]^prefix[i-1];
        }
        int index=0;
        for( int [] q:queries){
            int a = q[0];
            int b=q[1];

            if( a == 0){
                ans[index]=prefix[b];
            }
            else{
                ans[index]=prefix[b]^prefix[a-1];
            }
              index++;
        }
        return ans;
    }
}
