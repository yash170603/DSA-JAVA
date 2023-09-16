public class Solution{
    static class Stack {

        int size;
        int temp;
        int stack [];
        Stack(int capacity) {
           size= capacity;
           temp=-1;
           stack = new int [size];
        }
        public void push(int num) {
           if(temp>=size-1)
           return;
           temp += 1;
           stack[temp] = num;
        }
        public int pop() {

if(temp == -1)
return -1;

            int x =stack[temp];
          
            //stack[temp]=0;
            temp -=1;
             return x;
            
        }
        public int top() {
            if(temp<size)
            return stack[temp];
            else
            return 0;
        }
        public int isEmpty()
         {
             if(temp == -1)
            return 1 ;
            else 
            return 0;
        }
        public int isFull() {
            if(temp == size-1)
            return 1;
            else return 0;
        }
    }
}
