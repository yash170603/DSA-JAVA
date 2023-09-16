import java.util.LinkedList;
import java.util.Queue;

class MyStack {
   
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
    boolean f = false;
   
    public MyStack()
     {
         q1 = new LinkedList<>();
         q2 = new LinkedList<>();
    }
    
    public void push(int x) 
    {
        q2.add(x);
         while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    

    }
    
    public int pop() 
    {
      
       
      return q1.remove();
    }
    
    public int top() 
    {
        return  q1.peek();
    }
    
    public boolean empty()
     {
        if(q1.isEmpty() == true)
        f = true;
        return f;
        
    }
}

//using single qeue
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);

        // Rotate the elements in the queue to make the newly added element at the front
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

