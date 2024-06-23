/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Stack<Node> s = new Stack<>();
        Node curr = head;
        Node tail = head;

        while( curr!= null)
        {
            if( curr.child!=null)
            {
                Node children = curr.child;
                if( curr.next!=null)
                {
                     Node segment = curr.next;
                      curr.next.prev = null;
                     s.push(segment);
                }
                curr.next = children;
                children.prev = curr; 
                curr.child= null;
            }
            tail = curr;
            curr= curr.next;
        }

       while( !s.isEmpty())
       {
          curr= s.pop();
          tail.next = curr;
          curr.prev = tail;
          while( curr !=null)
          {
            tail= curr;
            curr = curr.next;
          }
       }

  return head;

    }

}
