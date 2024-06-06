class Solution {
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        target =t;
        List<Integer> a= new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        solve(0,0,candidates,a,b);
        return b;
    }


    public void solve(int index,int sum , int[] arr,List<Integer> a, List<List<Integer>> b )
    {
        if(sum>target|| index==arr.length)
        return;
        if(  sum == target)
        {
            
            b.add( new ArrayList<>(a));
           
            return;
        }
       
           sum+= arr[index];
           a.add(arr[index]);
           solve(index, sum,arr,a,b);
           sum-=arr[index];
           a.remove(a.size()-1);
           solve(index+1,sum,arr,a,b);
        
        

        return;
    }
}
