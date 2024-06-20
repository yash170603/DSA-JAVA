// passed 49/56
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n  = potions.length;
        int i =0;
        int j = n-1;
        Arrays.sort(potions);
        while( i<=j)
        {
            int temp = potions[i];
            potions[i] = potions[j];
            potions[j]= temp;
            i++;
            j--;
        }
        int ans []= new int [spells.length];
        int index=0;
        for( int a: spells)
        {
            int aws = find( a, potions,success);
            ans[index]=aws;
            index++;
        }
        return ans;
    }
    public int  find( int spell, int [] potions, long success)
    {
        int n  = potions.length;
        int low =0;
        int high = n-1;

        while( low<= high)
        {
            int mid = ( low+high)/2;

             if( (long)( potions[mid]*spell)>= success )
             {
                low=mid+1;
             }
             else
             high= mid-1;
        }

        return low;
    }
}




// correct appraoch
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
         Arrays.sort(potions); // Sort potions in ascending order
        
        int[] ans = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            ans[i] = countSuccessfulPairs(spells[i], potions, success);
        }
        
        return ans;
    }

      public int countSuccessfulPairs(int spell, int[] potions, long success) {
        int low = 0;
        int high = potions.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long) potions[mid] * spell >= success) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // All potions from low to the end of the array are successful pairs
        return potions.length - low;
    }
}
