// official ans was same as subsets sum = k but just k will be sum of all/2,
//which i think makes no sense eg 1,5,11,5 has only one subarray of 11, which is half of 22(sum of all)
// as two subsets as 11 and 5,5,1 
//its not always neccessary if we get an subset of sum/2, there will alwyas be only OND subset whose sum si equal to 11????? is it so?? revisit 
//new update- oopr waili meri baatein galat hai, koi arraya ka tot sum 12 hai , sirf eg, 2 subsets mei baatna hai ki sum equal ho , toh target totsum/2 hi hoga

// best code at last

class Solution {
    int dp [][];
    int t ;
    public boolean canPartition(int[] nums) {
        int sum =0;
        for( int x: nums)
        {
            sum+=x;
        }

        if( sum %2 !=0)
        return false;
        t= sum/2;
        dp = new int[nums.length][t+1];

        for( int y[]:dp)
        {
            Arrays.fill(y,-1);
        }
        int a= solve( 0,0,nums,dp);

        if ( a==1)
        return true;

        return false;
    }

    public int solve( int currentindex, int currentsum,int [] nums, int [][]dp)
    {
        if( currentindex >=nums.length)
        {
            if( currentsum == t)
            return 1;

            return 0;
        }
         if( currentsum == t)
            return 1;

        if( currentsum> t)
        {
            return 0;
        }

        if( dp [currentindex][currentsum] !=-1)
        
        {

            return dp [currentindex][currentsum];
        }

        int take = solve( currentindex+1,currentsum+nums[currentindex],nums, dp );
        int skip = solve( currentindex+1,currentsum,nums,dp);

        int ans=0;
        if( take ==1 || skip ==1)
        {
            ans=1;
        }

        return dp[currentindex][currentsum]= ans;
    }
}


// my approach, almost same bas mai sare unique sums ko store krwa ra tha hashset mei store kara ra tha
class Solution {
    HashSet<Integer> x;
    int dp [][];

    public boolean canPartition(int[] nums) {
        
        x = new HashSet<>();
        dp = new int [201][201];
        for( int d []:dp)
        Arrays.fill(d,-1);

        int x = solve( 0,0,dp,nums);
        

     return  (x ==1)?true:false;
    }

    public int solve( int currentindex, int currentsum, int [][] dp, int  [] nums)
    {
        if( currentindex>= nums.length)
        {
            if( x.contains(currentsum))
            return 1;

            return 0;
        }

        if( x.contains(currentsum))
        return 1;

        if( dp[currentindex][currentsum] !=-1)
        {
            return dp[currentindex][currentsum];
        }

        int take = solve(currentindex+1, currentsum+nums[currentindex],dp,nums);
        int skip = solve(currentindex+1,currentsum,dp,nums);

    int ans=0;
     if( take == 1 || skip ==1)
     ans=1;
        return dp[currentindex][currentsum] =ans;
    }
}




//best code

public class Solution {
	static int target;
	static Boolean dp[][];
	static int size;

	public static boolean canPartition(int[] arr, int n) {
		
		  int a=0;
		  for( int i :arr)
		  {
			  a+=i;
		  }
		   if (a % 2 != 0) {
            return false; // If sum is odd, can't partition into equal subsets
        }
 
		  target =a/2;
          size=n;
          dp = new Boolean[n+1][target+1];
          return solve(0,0,arr);
	}
	  public static Boolean solve( int currentindex, int currentsum , int [] arr)
    {
        if( currentsum == target)
        return true;
        if( currentindex>=size|| currentsum> target )
        {
            return false;
        }
        
        if( dp[currentindex][currentsum] != null)
        {
            return dp[currentindex][currentsum];
        }  
        Boolean take = solve( currentindex+1, currentsum+arr[currentindex],arr);
        Boolean skip = solve( currentindex+1, currentsum,arr);

        return dp[currentindex][currentsum] = take||skip;
     
     
    }
}
