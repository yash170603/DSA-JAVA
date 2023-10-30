/*The Stock Span problem can be efficiently solved using a stack-based approach. Here's the intuition behind the optimized solution:

We maintain two stacks: prices and spans. The prices stack keeps track of the stock prices, while the spans stack keeps track of the spans for each day.

For each day, we calculate the span of the current stock price. The span represents the number of consecutive days for which the stock price is less than or equal to the current day's price.

We iterate through the stock prices and maintain the following logic:

While the prices stack is not empty, and the current price is greater than or equal to the price at the top of the stack, we pop elements from the prices stack and add their corresponding spans to the span variable. This is because the current price is greater than or equal to the prices that have been popped, so they won't be part of the current span.

After popping elements and updating the span variable, we push the current price onto the prices stack and push the calculated span onto the spans stack. This ensures that we maintain the information about the stock prices and their corresponding spans.

By using this stack-based approach, we efficiently calculate the spans for each day, eliminating the need for additional data structures like a Queue.

The result is that we can quickly determine the span of the current stock price without needing to revisit previous stock prices multiple times.

Overall, this approach efficiently calculates the stock spans and keeps the code simple and optimized.*/
import java.util.Stack;

class StockSpanner {
    private Stack<Integer> prices;
    private Stack<Integer> spans;

    public StockSpanner() {
        prices = new Stack<>();
        spans = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!prices.isEmpty() && price >= prices.peek()) {
            prices.pop();
            span += spans.pop();
        }

        prices.push(price);
        spans.push(span);

        return span;
    }
}
//



/// my approach

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
class StockSpanner {
 public  Stack<Integer> s1;
 Queue<Integer> q ;
    public  StockSpanner()
     {
         s1 = new Stack<Integer>();
         q = new ArrayDeque<>();
      }
    
    public  int next(int price)
     {
         if(price > Math.pow(10,5))
         return 0;
         int count =1;

             if(  s1.isEmpty() == true ||s1.peek() > price )
               {
                 s1.push(price);
                 return 1;
               }
               
         else 
         {
             while(!s1.isEmpty() && s1.peek() <= price)
             {
                 int x= s1.pop();
                 q.add(x);  
                 count++;     
             }
             while(!q.isEmpty())
             {
                s1.push(q.poll());
             }
             s1.push(price);
              return count;

         }
    }
  
}
