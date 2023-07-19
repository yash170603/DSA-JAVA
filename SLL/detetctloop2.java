/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }                                       // This works as same for DLL.
   there is something wrong this works correctly but in my dry run it  work for ODD number of nodes please clear it out*/
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        
         if (head == null || head.next == null) {
            return false;
        }

         ListNode slow = head ,fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
       
    }
}
