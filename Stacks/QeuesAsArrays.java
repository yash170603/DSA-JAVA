public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            arr[front] = e;
            front+=1;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(rear >= front ) // can be == as well, mfing compiler
            return -1;
            int x= arr[rear];
           
            rear = rear+1;
             return x;
           
        }
    }
}
