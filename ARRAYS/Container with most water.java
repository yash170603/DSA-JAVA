class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0,r=n-1;
        int ans=0;
        while(l<r)
        {
            int width=r-l;
            int area= width*Math.min(height[l],height[r]);
            ans=Math.max(ans,area);
            if(height[l]<height[r]){
                    l++;
            }
            else{
                r--;
            }
        }

        return ans;
    }
}
