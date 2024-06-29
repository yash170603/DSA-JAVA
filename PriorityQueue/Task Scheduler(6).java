class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        int time=0;
        Queue<int []> q = new LinkedList<>();
        int freq[]= new int[26];
        for( char ch :tasks)
        {
            freq[ch-'A']++;
        }
        for( int i =0;i<freq.length;i++)
        {
            if(freq[i]>0)
            pq.offer(freq[i]);
        }

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int currCount = pq.poll() - 1;
                if (currCount > 0) {
                    int nextTime = time + n;
                    q.offer(new int[] { currCount, nextTime });
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }
        }
      return time;
    }
}
