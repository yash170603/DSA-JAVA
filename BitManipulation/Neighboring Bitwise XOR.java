class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int ans=0;
        for(int x:derived){
            ans=ans^x;
        }
        return ans==0;
    }
}
