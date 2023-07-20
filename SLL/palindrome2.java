class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is always a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list starting from the middle node
        ListNode reversedSecondHalf = reverseLinkedList(slow);

        // Step 3: Compare the first half with the reversed second half element by element
        while (reversedSecondHalf != null) {
            if (head.val != reversedSecondHalf.val) {
                return false;
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
