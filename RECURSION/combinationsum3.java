class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] arr=new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        func(0,k,n,ds,arr,ans);
        return ans;
    }

    public void func(int idx,int len,int target,List<Integer> ds,
                     int [] arr,List<List<Integer>> ans)
    {
        if(idx==arr.length){
            if(ds.size()==len && target==0) ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[idx]);
        func(idx+1,len,target-arr[idx],ds,arr,ans);
        ds.remove(ds.size()-1);
        func(idx+1,len,target,ds,arr,ans);
    }


}
