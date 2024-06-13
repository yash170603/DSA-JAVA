class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        
        int windex =0;
        int streak=0;

        for(int i =1; i< skills.length;i++)
        {
            if( skills[i] > skills[windex])
            {
                windex=i;
                streak=1;
            }
            else
            {
                streak++;
            }

            if( streak==k)
            {
                break;
            }
        }

        return windex;
    }
}
