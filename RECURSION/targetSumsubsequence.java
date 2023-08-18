import java.util.*;
public class jj
 {   //prints all subseqquences
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



//prints only one subsequence
import java.util.*;
public class sumsequence
 {            //gives only 1 subsequence
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
 
   public static boolean prints(int [] arr,  ArrayList<Integer> x, int i, int sum, int target)
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
       return true;
        }
      
        return false ;
       }

        x.add(arr[i]);
        sum +=  arr[i];
       if(prints(arr,  x, i+1, sum, target) == true) 
       return true;
        x.remove(x.size()-1);
        sum -= arr[i];
        if(prints(arr,  x, i+1, sum, target) == true) 
        return true;




        return false;


   }
}






//prints count of sub 
import java.util.*;

public class countsubsequence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {3, 2, 1, 4, 6};

        int i = 0;
        int sum = 0;
        int target = 4;
        int count = 0;  // Counter for the valid subsequences
        ArrayList<Integer> x = new ArrayList<>();
        count = prints(arr, x, i, sum, target, count);

        System.out.println("Count of valid subsequences: " + count);
    }

    public static int prints(int[] arr, ArrayList<Integer> x, int i, int sum, int target, int count) {
        if (i == arr.length) {
            if (sum == target) {
                count++;
            }
            return count;
        }

        // Include the current element
        x.add(arr[i]);
        sum += arr[i];
        count = prints(arr, x, i + 1, sum, target, count);

        // Exclude the current element
        x.remove(x.size() - 1);
        sum -= arr[i];
        count = prints(arr, x, i + 1, sum, target, count);

        return count;
    }
}

