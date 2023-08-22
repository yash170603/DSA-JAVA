import java.util.* ;    //returns sum of all subsets in increasing order

import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[])
     {
       
          int i =0;
         ArrayList<Integer> b = new ArrayList<>();//current subset
         ArrayList<Integer> a = new ArrayList<>();//sum of current subset
         sum1(num,i,a,b);
         Collections.sort(a);
         return a;



       
    }


    public static void sum1(int num[], int i, ArrayList<Integer> a,ArrayList<Integer> b)
    {
       
         if(i == num.length)
         {

             int v=0;
             for(int k=0;k<b.size();k++)
             {
                v += b.get(k);
             }

             a.add(v);

             return;




         }


          b.add(num[i]);
          sum1(num,i+1,a,b);
          b.remove(b.size() -1);
          sum1(num,i+1,a,b);



    } 

}
