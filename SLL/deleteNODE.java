/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
      val = x;
       }
 * }
/*
    Time Complexity: O( n )
    Space Complexity: O( 1 )

    where 'n' is the number of elements in the linked list.
*/
public class Solution {
    public static Node deleteLast(Node list){
        // Creating a dummy node 'head', and assigning it to 'list'
        Node head = list;

        while (head.next != null && head.next.next != null)
        {
            head = head.next;
        }

        // Assigning the 'next' of second last node 'NULL'.
        head.next = null;
        return list;
    }
}











class Solution {
   public void deleteNode(ListNode node) {
        if (node == null) return;
        ;
        if (node.next != null) {
            int nextValue = node.next.val;
            node.next = node.next.next;
            node.val = nextValue;
        }
    }
}
