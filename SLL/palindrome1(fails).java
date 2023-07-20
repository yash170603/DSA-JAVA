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
    public boolean isPalindrome(ListNode head)
     {
         boolean f = false;
         ListNode j = head;
       
           ListNode newHead = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
               ListNode k = newHead.next;

        while(j.next != null )
        {
            if(j == k)
            {
                f = true;
            }

            j= j.next;
            k=k.next;
        }

        return f;
    }
}












