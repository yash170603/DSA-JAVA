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

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        if (head == null || head.next == null) {
        // If the list is empty or has only one node, return head
        return head;
    }

    Node current = head;
    Node previous = null;

    while (current != null) {
        // Reverse the prev and next pointers of the current node
        Node nextNode = current.next;
        current.next = previous;
        current.prev = nextNode;
        previous = current;
        current = nextNode;
    }

    // Return the new head node (which is the previous node of the original head)
    return previous;
    }
}
