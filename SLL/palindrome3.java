import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is always a palindrome
        }

        // Find the middle of the linked list using the slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the list has an odd number of nodes, move slow pointer one step ahead
        if (fast != null) {
            slow = slow.next;
        }

        // Push the first half of the list onto a stack
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != slow) {
            stack.push(current);
            current = current.next;
        }

        // If the list has an odd number of nodes, skip the middle element for comparison
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the second half of the list with the elements in the stack
        while (slow != null) {
            if (slow.val != stack.pop().val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
