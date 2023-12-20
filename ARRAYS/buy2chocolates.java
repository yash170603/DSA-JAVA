/*You are given an integer array prices representing the prices of various chocolates in a store.
You are also given a single integer money, which represents your initial amount of money.
You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. 
You would like to minimize the sum of the prices of the two chocolates you buy.
Return the amount of money you will have leftover after buying the two chocolates.
If there is no way for you to buy two chocolates without ending up in debt, return money. Note that the leftover must be non-negative.
Example 1:
Input: prices = [1,2,2], money = 3
Output: 0
Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
Example 2:
Input: prices = [3,2,3], money = 3
Output: 3
Explanation: You cannot buy 2 chocolates without going in debt, so we return 3.*/

//500 testcase outof 2000
class Solution {
    public int buyChoco(int[] prices, int money)
     {
         int count =0;
         int originalmoney = money;
         for( int b : prices)
         {
             if( count == 2 &&  money >=0)
             break;
             if( count <2 && money ==0)
             return originalmoney;

             if( b<= money)
             {
                 count++;
                 money = money-b;
             }
         }

         return money;
        
    }
}

//600/2000
class Solution {
    public int buyChoco(int[] prices, int money) 
    {
        int originalmoney = money;
        int count=0;
        ArrayList<Integer> d = new ArrayList<Integer>();
        for( int i: prices)
        {
            d.add(i);
        }
        Collections.sort(d);

        for( int j: d)
        {
            if( count <2 && money <j)
            return originalmoney;
               
               if( count ==2 && money>=0)
               break;
            if( money>= j)
            {
                count++;
                money = j-money;
            }

        }

        return money;
        
    }
}


// full
class Solution {
    public int buyChoco(int[] prices, int money) {
        
        Arrays.sort(prices);

        if(money - prices[0] - prices[1] >= 0){
            return money - prices[0] - prices[1];
        }
        
        return money;
    }
}
