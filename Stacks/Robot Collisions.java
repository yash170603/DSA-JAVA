import java.util.*;

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        Stack<int[]> s = new Stack<>();
        List<int[]> x = new ArrayList<>(); // right ==1, left ==0
        int n = positions.length;
        
        for (int i = 0; i < n; i++) {
            x.add(new int[]{positions[i], healths[i], (directions.charAt(i) == 'R') ? 1 : 0, i});
        }
        Collections.sort(x, (a, b) -> Integer.compare(a[0], b[0]));
      
        for (int[] arr : x) {
            while (!s.isEmpty() && s.peek()[2] == 1 && arr[2] == 0) { // R -> L collision
                int[] top = s.peek();
                if (top[1] > arr[1]) {
                    top[1] -= 1;
                    s.pop();
                    s.push(top);
                    arr[1] = 0; // Current robot is destroyed
                    break;
                } else if (top[1] < arr[1]) {
                    arr[1] -= 1;
                    s.pop();
                } else {
                    s.pop();
                    arr[1] = 0; // Both are destroyed
                    break;
                }
            }
            if (arr[1] > 0) {
                s.push(arr);
            }
        }
        
        List<int[]> d = new ArrayList<>();
        while (!s.isEmpty()) {
            d.add(s.pop());
        }
        
        Collections.sort(d, (a, b) -> Integer.compare(a[3], b[3]));
        
        List<Integer> ans = new ArrayList<>();
        for (int[] p : d) {
            ans.add(p[1]);
        }
        
        return ans;
    }

    
}




// this passed 350/2344

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        Stack<int[]> s = new Stack<>();
        List<int[]> x = new ArrayList<>(); // right ==1, left ==0;
        int n = positions.length;
        for( int i = 1;i<=n;i++)
        {
            x.add( new int []{positions[i-1],healths[i-1],(directions.charAt(i-1)=='R')?1:0,i});
        }
        Collections.sort(x, (a,b)->a[0]-b[0]);
      //  List<Integer>ans= new ArrayList<>();

        for( int arr [] : x)
        {
            if( s.isEmpty() || s.peek()[2] == arr[2] || (s.peek()[2] ==0 && arr[2] ==1)  )  // same direction   OR last element goin left, coming goes right
            {
                s.push(arr);
            }
            else   // directions different hai, R->  <-L
            {
                     while( !s.isEmpty() &&  (s.peek()[2] == 1 && arr[2]==0)) {   // R-> R->  <-L
                             if( s.peek()[1]>arr[1])
                             {
                                  int temp []= s.pop();
                                  temp[1]=temp[1]-1;
                                 s.push(temp);
                                 break;
                             }
                             if( s.peek()[1]<arr[1])
                             {
                                s.pop();
                                s.push( new int[]{ arr[0],arr[1]-1,arr[2],arr[3]});
                             }
                             if( s.peek()[1] == arr[1])
                             {
                                s.pop();
                                break;
                             }
                     }                                     


            }
        }
        List<int[]> d= new ArrayList<>();
        while( !s.isEmpty())
        {
            d.add(s.pop());
        }
        Collections.sort(d, (a,b)->a[3]-b[3]);

        List<Integer> ans = new ArrayList<>();
        for( int p[]:d)
        {
            ans.add(p[1]);
        }

        return ans;
    }
}


fails this positions =
[11,44,16]
healths =
[1,20,17]
directions =
"RLR"

Use Testcase
Output
[1,19]
Expected
[18]
