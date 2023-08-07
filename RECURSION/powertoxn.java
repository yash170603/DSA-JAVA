class Solution {// 95 percent test caseswere passed
    public double myPow(double x, int n) {
                       
                       double RESULT =0;

          if(n>=0)
          {
                 RESULT =  power(x,n);
          } 
          else
           {
                RESULT = (1/power(x,(-1*n)));
           }

       
      
return RESULT;

          
    }
    public double power(double x,int n)
    {
        if(n ==0)
        {
            return 1;

        }

        double xnm1 = power(x,n-1);
        double result = x * xnm1;
        return result;
    }
}























//new methods 
public class Solution {
    public double solve(double x, long n) {
        if (n == 0) {
            return 1; // power of 0 is 1
        }
        double temp = solve(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) { // if even, return just without doing anything
            return temp;
        } else {
            return temp * x; // if odd, return by multiplying once more with the given number
        }
    }

    public double myPow(double x, int n) {
        long longN = n; // Convert n to a long to handle Integer.MIN_VALUE
        double ans = solve(x, Math.abs(longN));

        if (longN < 0) {
            return 1 / ans;
        }
        return ans;
    }
}





// new method 2
public class Solution {
    public double solve(double x, long n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) { // checking if it is odd then we will multiply one extra value of x
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        if (x == 1) return 1;
        long longN = n;
        double ans = solve(x, Math.abs(longN));
        if (longN < 0)
            return 1 / ans;
        return ans;
    }
}
