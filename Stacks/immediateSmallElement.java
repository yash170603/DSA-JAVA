/*
	Time Complexity: O(N)
	Space complexity: O(N)

	Where N is the number of elements in the array.
*/

import java.util.Stack;

public class Solution
{

    public static void immediateSmaller(int []a)
    {
        int n = a.length;
        // Use a stack to store previous element
        Stack<Integer> s = new Stack<>();
        s.add(a[0]);

        for (int i = 1; i < a.length; i++)
        {
            // If the top is greater than the current element then copy the current element to previous
            if (s.peek() > a[i])
            {
                a[i - 1] = a[i];
            }
            else
            {
                // Else set it to -1;
                a[i - 1] = -1;
            }

            // Push the current element to top for next Iteration
            s.add(a[i]);
        }

        // Finally for the last element put it as -1
        a[n - 1] = -1;
    }
}

