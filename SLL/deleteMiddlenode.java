/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) 
    {
        
      ListNode  slow = head;
      ListNode  fast = head;

      if(head.next == null)
      {
          return null;
      }
      while(fast != null && fast.next != null)
      {
          slow = slow.next;
          fast = fast.next.next;
      }
      
      ListNode c1 = head;
      while(c1.next!= slow)
      {
          c1 = c1.next;
      }
      
       ListNode c2 = slow.next;

       c1.next = c2;


       return head;



    }
}
