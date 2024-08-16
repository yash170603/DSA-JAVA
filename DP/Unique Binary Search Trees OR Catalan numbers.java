class Solution {
    public int numTrees(int n) {
             return solve(n);
     }

     public int solve( int n){
        int arr[]= new int[n+1];
        
        //Arrays.fill(arr,0);
        arr[0]=1;
        arr[1]=1;
        for( int i= 2;i<=n;i++){
            arr[i]=0;
            for( int j=0;j<i;j++){
                arr[i]+=arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
     }
}


formula- The formula for finding the number of Binary Search Trees (BSTs) with n nodes using Catalan numbers is:

C(n) = (2n)! / (n! * (n+1)!)

where C(n) is the nth Catalan number.

This formula can be used to find the number of BSTs with n nodes, because the number of BSTs with n nodes is equal to the nth Catalan number.

For example, to find the number of BSTs with 3 nodes, you would calculate:

C(3) = (2*3)! / (3! * (3+1)!) = 6! / (3! * 4!) = 720 / (6 * 24) = 20
