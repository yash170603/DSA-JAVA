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
    public ListNode middleNode(ListNode head) 
    {
         ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
         


    }
}

/*2nd method class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;

        // Calculate the length of the linked list
        while (current.next != null) {
            length++;
            current = current.next;
        }

        int middle = length / 2;
        current = head;

        // Traverse to the middle node
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }

        return current;
    }
}
*/
