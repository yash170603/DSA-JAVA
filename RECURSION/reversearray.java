import java.util.*;
public class reversearrayrecursion 
{
//Palindrome string can be check by this way to if arr[i] != arr[n-i-1]  return ;
     public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        int a [] = {1,2,3,4,5};
        int v = a.length -1;
        int y =0;
        reversearray(a, y,v );
        for(int x : a)
        {
            System.out.print(x);
        }

    }

    public static void reversearray(int []a, int y , int v)
    {
        int temp = a[y];
        a[y] = a[v];
        a[v] = temp;
        if(v == y)
        return;

        reversearray(a, y+1, v-1);
     }








}
