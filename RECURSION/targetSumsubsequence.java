import java.util.*;
public class jj
 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int arr [] ={3,2,1,4,6};
        
        int  i =0;
        int sum= 0;
        int target = 4;
        ArrayList<Integer> x = new ArrayList<>();
        prints(arr,x,i,sum,target);

    }
 
   public static void prints(int [] arr,  ArrayList<Integer> x, int i, int sum, int target)
   {

       if(i == arr.length)
       {
        if( sum == target)
        {
           for(int j =0 ;j<x.size();j++)
        {
            System.out.print(x.get(j));
            System.out.print(" ");
        }
          System.out.println();
        }
      
        return ;
       }

        x.add(arr[i]);
        sum +=  arr[i];
        prints(arr,  x, i+1, sum, target);
        x.remove(x.size()-1);
        sum -= arr[i];
        prints(arr,  x, i+1, sum, target);


   }
}
