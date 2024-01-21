class Solution {
    public int minimumArrayLength(int[] nums)
     {

         if( nums.length == 1) return 1;
         ArrayList<Integer> x = new ArrayList<>();
         for( int i :nums)
         {
             x.add(i);
         }
         Collections.sort(x);
         int least = x.get(0);
         int countleast=0;
         
       

         for( int v =0;v<nums.length;v++)
         {
             if( nums[v]%least !=0 && nums[v]%least<least)
             {
                 return 1;
             }
         }

          for (int j = 0; j < x.size(); j++) {
            if (x.get(j).equals(least)) {
                countleast++;
            }
        }

         return ( countleast+1)/2;
        
    }
}
