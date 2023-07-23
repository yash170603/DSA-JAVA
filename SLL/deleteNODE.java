/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
      val = x;
       }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {
         ListNode current = node;
        ListNode prev = null;

        while (current.next != null) {
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }

        prev.next = null;
    }
}
