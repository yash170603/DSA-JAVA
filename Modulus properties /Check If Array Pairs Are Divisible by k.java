class Solution {
    public boolean canArrange(int[] arr, int k) {
           
           int n = arr.length;
           int  [] map = new int[k];
           for( int i =0;i<n;i++){
               int mod = ((arr[i]%k)+k)%k;
               map[mod]++;
           }

           if( map[0]%2!=0) return false;

           for( int j=1;j<=k/2;j++){ 
               int a = map[j];
               int b = map[k-j];
               if( a!=b) return false;
           }


           return true;
    }
}
