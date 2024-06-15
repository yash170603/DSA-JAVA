import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
       if (m > n) return -1;
        
        int low = Collections.max(arr); // Start with the maximum single book
        int high = 0;
        for (int i = 0; i < arr.size(); i++) {
            high += arr.get(i); // Sum of all pages
        }

        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredStudents = solve(mid, arr); 

            if (requiredStudents <= m) {
                result = mid; // mid is a potential solution
                high = mid - 1; // Try for a better minimum
            } else {
                low = mid + 1; // Increase the limit since more students are required
            }
        }
        return result;
    }
    public static  int solve( int pages, ArrayList<Integer> arr)
    {
        int nos =1; // no of students
        long nop =0; // no of pages holded by student 1

        for( int a =0; a< arr.size();a++)
        {
            if( nop+arr.get(a)<=pages)
            {
                nop+=arr.get(a);
            }
            else
            {
                nos++;
                nop= arr.get(a);
            }
        }

        return nos;
    }
}


/*
*sorting - nlogn
bs = log(high)
solve = o(n)

total = nlogn+ (log(s).n)


*/
