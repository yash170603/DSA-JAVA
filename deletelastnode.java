/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node deleteLastNode(Node head) 
    {
    
 if (head == null || head.next == null) {
        // If the list is empty or has only one node
        return null;
    }
    
    Node current = head;
    while (current.next != null) {
        // Traverse to the last node
        current = current.next;
    }
    
    // Update the references
    current.prev.next = null;
    
    return head;
         




    }
}
