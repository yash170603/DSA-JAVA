/*Approach:
To determine the total number of edges possible in a graph with 'N' vertices, we can use the combination formula.
Each edge requires two vertices so we can choose any two vertices from the 'N' vertices.
Therefore, the total number of edges possible, denoted as 'E', is given by the formula E = (N * (N-1)) / 2.
Now, when counting the total number of graphs, we can consider that each edge in the graph may either exist or not exist.
This gives us two options for each edge. Since there are 'E' edges, the total number of possible combinations of edge choices is 2^E.
This represents all the different possible graphs that can be formed.
By right-shifting 1 'E' times, we essentially multiply 1 by 2 'E' times, which is equivalent to 2^E.
This reduces the time complexity from O(log E) due to the power function to O(1). 
Although ‘E’ is relatively small but it is a good practice to use right shift instead of power for calculating a power of 2.
Algorithm:
declare ‘ans’ as a 32-bit integer
declare ‘E’ as a 32-bit integer
E = (N * (N-1)) / 2
ans = 1 << E
return ans
Time Complexity
O(1)
We are using right shift operation, which takes O(1) time.
Space Complexity
O(1)
We are not using any extra space, thus the constant space complexity.*/

public class Solution {
    public static int countingGraphs(int N)
     {
         int edges, no_of_graphs;

         edges = (N*(N-1))/2;
         no_of_graphs = 1<<edges;

         return no_of_graphs;
       
    }
}
