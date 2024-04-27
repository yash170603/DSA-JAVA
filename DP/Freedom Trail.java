class Solution {
    int dp[][];  // explained below
    int n;
    int m;
    public int findRotateSteps(String ring, String key)
     {
        n= ring.length();
        m= key.length();
        dp= new int [n+1][m+1];
        for( int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        return  solve(0,0,ring,key);
    }
    public int solve( int ptr, int index, String ring, String key)
    {
        if( ptr>=n || index>=m)
        return 0;

        if( dp [ptr][index] !=-1)
        return dp[ptr][index];
        int steps= 1000000009;
        for( int i =0;i<n;i++)
        {
            if( ring.charAt(i)== key.charAt(index))
            {
                steps= Math.min( steps, Math.min( Math.abs(i-ptr),n- Math.abs( i-ptr)) +1 + solve(i, index+1,ring, key) );
            }
        }
       return  dp[ptr][index] = steps;
    }
}



// approach


// ring = godding, key = dg

//   inittially ptr is at g and index is at d
// loop iterates and find that at rings 2nd pos d appears first time,
//   then it check the shortest path to d from initial point i.e ptr or in this case g
//   then from there( i-ptr) no of steps + 1(locking) + solve ( i,index+1,ring,key) is called
//   as now the position we are at is 2= ptr,
//   ( in circular diagram g se d jao, then waps usi g pr jaa skte hai, pr usi g pr jane k liye hamar starting pos 2 (d) hogi,
//   isiliye next mei starting post ptr =i bheji hai jhn first appearnce hui thi d ki) index+1 is for (g) in key
  
  
