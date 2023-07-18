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
    public static Node insertAtTail(Node list, int K) 
    {
        

        Node newNode = new Node(K);
        
    
    if (list == null) {
        // If the linked list is empty, make the new node as the head
        return newNode;
    }
    
    Node current = list;
    
    while (current.next != null) {
        // Traverse to the last node of the linked list
        current = current.next;
    }
    
    // Attach the new node to the last node
    current.next = newNode;
    newNode.prev = current;
    
    return list;
   
         }
         
         
          










        
    }
