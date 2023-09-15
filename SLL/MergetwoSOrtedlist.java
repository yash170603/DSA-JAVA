//passes 75 percent cases
import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode x = list1;
        while (x.next != null ) {
            x = x.next;
        }

        x.next = list2;

        LinkedList<Integer> ans = new LinkedList<>();
        ListNode current = list1; // Start from the beginning of the merged list
        for (int i = 0; i < 50 && current != null; i++) {
            ans.add(current.val);
            current = current.next;
        }

        Collections.sort(ans);

        ListNode dummy = new ListNode(0);
        ListNode n = dummy;
        for (int i = 0; i < 50 && !ans.isEmpty(); i++) {
            ListNode a = new ListNode(ans.removeFirst());
            n.next = a;
            n = n.next;
        }

        return dummy.next;
    }
}



//passes full 
ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
