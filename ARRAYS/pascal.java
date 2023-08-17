
import java.util.*;

public class pascal {
    public static int pascalTriangle(int n, int r) {
        int res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);        //res = res * ((n-i)/(i+1)); shows wrong answer bcs of gierarchy of operators
        }
        
        return res;
    }

    /*public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }*/

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r-1, c-1);
        System.out.println("The element at position (r,c) is: " + element);
    }
}  












//2nd approach 
import java.util.*;
class pascal2nd
{
public static int nCr(int n, int r) {
        int res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);        
        }
        return res;
    }

    public static void pascalTriangle(int N) 
    {
      
       for(int i =0;i<N;i++)
       {
        System.out.print(nCr(N-1, i) + " ");
       }
       
       System.out.println();
        
    }

    public static void main(String[] args) {
        int N=4;
        pascalTriangle(N);
    }
}  













//3rd approach

import java.util.*;
 class pasacal3rd {
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);        //res = res * ((n-i)/(i+1)); shows wrong answer bcs of gierarchy of operators
        }
        return res;
    }

    public static void pascalTriangle(int N) 
    {
        
       for(int i =0;i<N;i++)
       {
        System.out.print(nCr(N-1, i) + " ");
       }
       
       System.out.println();
        
    }

    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter till where do you want to print");
        int h= sc.nextInt();

        for(int j=0; j<=h;j++)
        {
               pascalTriangle(j);
        }

        
    }
}  
        
