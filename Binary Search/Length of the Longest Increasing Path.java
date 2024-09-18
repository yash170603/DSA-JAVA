class Solution {
    public int maxPathLength(int[][] cd, int k) {
        int n= cd.length;
        int kx=cd[k][0];
        int ky=cd[k][1];

        Arrays.sort( cd, (a,b)-> {
              if(a[0]==b[0]) return b[1]-a[1];
              return a[0]-b[0];
        });

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for( int arr[]: cd){
            int a=arr[0];
            int b=arr[1];
            if( a<kx && b< ky) left.add(b);
            if( a>kx && b>ky) right.add(b);
        }
          int [] dp= new int[n];
          int x= solve( left,dp);
          int y = solve(right,dp);
        return x+y+1;

    }
    public int solve(List<Integer>list, int [] dp){
        int size=0;
        for( int i: list){
           int pos= Arrays.binarySearch(dp,0,size,i);
           if( pos<0) pos=-(pos+1);

           dp[pos]=i;
           if(pos==size) size++;
        }
        return size;
    }


}
