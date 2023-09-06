//My approach passed 62percent, failed for [2,4,1]
class Solution {
    public int maxProfit(int[] prices)
     {
        int counter =0;
         int least =prices[0];

        for(int i =0;i<prices.length;i++)
        {
            if(prices[i]<= least)
            {
                least = prices[i];
                counter = i;
            }
        }

        if(counter == prices.length -1)
        {
            return 0;
        }
          
          int max = prices[counter];

        for(int j = counter;j<prices.length;j++)
        {
            if(prices[j] > max)
            {
                max = prices[j];
            }
        }
  
       return max-least;



    }
}





// 1st approach
/*take each element and consider it as least, then immediately check for the profit and check for max profit in the same iteration.*/
class Solution {
    public int maxProfit(int[] arr) {
        int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        minPrice = Math.min(minPrice, arr[i]);
        maxPro = Math.max(maxPro, arr[i] - minPrice);
    }
    return maxPro;
        
    }
}


// 2nd approach

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    static int maxProfit(int[] arr) {
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }
}
