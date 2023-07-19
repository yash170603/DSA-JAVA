/**   recursive approach
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode nnode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nnode;
    }
}


/*/**  iterative approach
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        
         ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}   Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
newHead = null



head = 1 -> 2 -> 3 -> 4 -> 5 -> null
next = 2 -> 3 -> 4 -> 5 -> null
head.next = null
newHead = 1 -> null
head = 2 -> 3 -> 4 -> 5 -> null




head = 2 -> 3 -> 4 -> 5 -> null
next = 3 -> 4 -> 5 -> null
head.next = 1 -> null
newHead = 2 -> 1 -> null
head = 3 -> 4 -> 5 -> null






head = 3 -> 4 -> 5 -> null
next = 4 -> 5 -> null
head.next = 2 -> 1 -> null
newHead = 3 -> 2 -> 1 -> null
head = 4 -> 5 -> null







head = 4 -> 5 -> null
next = 5 -> null
head.next = 3 -> 2 -> 1 -> null
newHead = 4 -> 3 -> 2 -> 1 -> null
head = 5 -> null






head = 5 -> null
next = null
head.next = 4 -> 3 -> 2 -> 1 -> null
newHead = 5 -> 4 -> 3 -> 2 -> 1 -> null
head = null



head is null, so the loop exits.


newHead = 5 -> 4 -> 3 -> 2 -> 1 -> null

*/
