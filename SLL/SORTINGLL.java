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
    public ListNode sortList(ListNode head) {
        /*
        //Approach1: just I got this approach in my mind when I show this question
        //T.C: O(nlogn), S.C: O(n)
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(list);
        curr = head;
        for(int num : list){
            curr.val = num;
            curr = curr.next;
        }
        return head;
        */
        //Approach2: Using MergeSort
        // Base case: If the list is empty or has only one element, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        // Find the middle of the list using the slow and fast pointer approach
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Split the list into two halves at the middle node
        ListNode mid = slow.next;
        slow.next = null;
        // Recursively sort the two halves of the list
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // Merge the two sorted halves of the list
        return merge(left, right);
    }
    // Merge two sorted linked lists into a single sorted linked list
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // Compare the values of the nodes in l1 and l2 and add the smaller value to the merged list
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // Add the remaining nodes of l1 or l2 to the merged list
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummy.next;
    }
}
