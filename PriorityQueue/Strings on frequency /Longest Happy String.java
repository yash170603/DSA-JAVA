import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.count, x.count));
          
        if (a > 0) pq.offer(new Node('a', a));
        if (b > 0) pq.offer(new Node('b', b));
        if (c > 0) pq.offer(new Node('c', c));
      
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

     
            if (ans.length() > 1 && ans.charAt(ans.length() - 1) == curr.ch && ans.charAt(ans.length() - 2) == curr.ch) {

                if (pq.isEmpty()) break; 

                Node next = pq.poll();
                ans.append(next.ch);
                next.count--;
                
                if (next.count > 0) {
                    pq.offer(next);
                }

                pq.offer(curr);
            } else {

                ans.append(curr.ch);
                curr.count--;
                if (curr.count > 0) {
                    pq.offer(curr);
                }
            }
        }

        return ans.toString();
    }
}

class Node {
    int count;
    char ch;
    Node(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
