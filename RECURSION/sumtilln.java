import java.util.*;

class rec2 //functional recursion
{

public static void main(String args[])
{
    Scanner sc = new Scanner (System.in);
    int n= 5;
    
     int i =1;
    sum(n,i);
    
}


public static int sum(int n, int i)

{
    if(i > n) {
        return 0; // Terminate the recursion
    }
    
    return i + sum(n, i+1);

}



}


//parametric recursion 
public class rec6 
{
    public static void main(String args[])
    {
    int sum =0;
    int n=5;
    add(n,sum);
}

public static void add(int n, int sum)
{
    if(n<1)
    {
        System.out.println(sum);
        return;
    }
    add(n-1, sum+n);
}





}














 
