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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        if(head.next ==null && n==1){
            return null;
        }
        
        ListNode curr = head;
        int p=0;
        while(curr!=null){
            curr = curr.next;
            p++;
        }
        if(n==p){
            head = head.next;    
            return head;
        }
        ListNode a = head;
        int t=0;
        while(t<(p-n-1)){
          a= a.next ;
          t++;
        }
        a.next = a.next.next;
  return head;  }
}


/*/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
         ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
        
    }
}*/
