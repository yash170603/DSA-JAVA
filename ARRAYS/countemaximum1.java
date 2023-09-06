import java.util.*;
import java.util.ArrayList;
class max1 {

    public static void main(String args[])
    {
        int nums[] ={1,1,0,1,1,1};
        int c = findMaxConsecutiveOnes(nums);
        System.out.print(c);
    }
    public  static int findMaxConsecutiveOnes(int[] nums)
     {
        ArrayList<Integer> x  = new ArrayList<Integer>();
        
        int counter =0;

        for(int i =0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                counter++;
            }
x.add(counter);
             if( nums[i] ==0)
            {
                
                counter =0;
            }
        }

        Collections.sort(x);
        int v = x.size();
        int h = x.get(v-1);

        return h;
        


    }
}
