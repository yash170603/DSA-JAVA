import java.util.*;

class rec2 
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
 
