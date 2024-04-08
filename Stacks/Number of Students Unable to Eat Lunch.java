class Solution {
    public int countStudents(int[] student, int[] sand) {
         // here t.c may look like o(N) but no not true, its almost >= o(n2)
       // ek element hatne k baad new ques poori traverse hori agar element last mei hai
        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<>();

        for(int i= sand.length-1;i>=0;i--)
        {
            s.push(sand[i]);
        }

        for( int j =0;j<student.length;j++)
        {
            q.offer( student[j]);
        }
              int lastnotserved=0;
        while( ! q.isEmpty() && lastnotserved < q.size())
        {
            if( s.peek() == q.peek())
            {
                s.pop();
                q.poll();
                lastnotserved=0;
            }

            else
            {
                int d = q.peek();
                q.poll();
                q.offer(d);
                lastnotserved++;  //  this is the main logic, check how may students were unluck before this mf got luck and got his sandwhich
            }
        }

        return lastnotserved;
    }
}


// 2nd approach
//kind of greedy , agar q mei koi aisa hai jisko pehla sandwhich chaiye toh vo le jaega. something like thsi

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroCount = 0, oneCount = 0;

        for (int student : students) {
            if (student == 0) zeroCount++;
            else oneCount++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && zeroCount == 0) return oneCount;
            if (sandwich == 1 && oneCount == 0) return zeroCount;
            
            if (sandwich == 0) zeroCount--;
            else oneCount--;
        }

        return 0;
    }
