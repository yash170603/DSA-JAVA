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
    public ListNode mergeKLists(ListNode[] list) {
        if(list == null || list.length ==0 )
        return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode n:list)
        {  
            if(n!=null)
            q.offer(n);
        }
        ListNode dummy= new ListNode(0);
        ListNode curr = dummy;

        while(!q.isEmpty())
        {
            ListNode node = q.poll();
            curr.next = node;
            curr=curr.next;

            if(node.next!=null)
            {
                q.offer(node.next);
            }
        }

        return dummy.next;

    }
}
