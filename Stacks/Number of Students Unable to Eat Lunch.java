class Solution {
    public int countStudents(int[] student, int[] sand) {
        

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
                lastnotserved++;
            }
        }

        return lastnotserved;
    }
}
