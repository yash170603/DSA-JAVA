public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        
         if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next ;
        }

        return true;
                     //This works for even number of nodes,in my dry run but works fine on compiler, please checks it.
    }
}
