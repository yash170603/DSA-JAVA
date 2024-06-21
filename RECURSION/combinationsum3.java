class Solution {
    int n ;
    public List<List<Integer>> combinationSum3(int k, int nn) {
        List<Integer> a= new ArrayList<>();
        List<List<Integer>> b= new ArrayList<>();
        n=nn;
        solve(1,0,a,b,k);
        return b;
    }

    public void solve( int index, int sum, List<Integer> a, List<List<Integer>> b,int k)
    {
        
        if( a.size() >= k)
        {
              if(sum == n)
              {
                b.add(new ArrayList<>(a));
                return;
              }

              return;
        }

        for( int i = index;i<=9;i++)
        {
            sum+=i;
            a.add(i);
            solve( i+1, sum,a,b,k);
            sum= sum-i;
            a.remove(a.size()-1);
        }

        return;
    }
}
