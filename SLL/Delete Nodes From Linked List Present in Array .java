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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> badset = new HashSet<>();
        for( int i : nums){
            badset.add(i);
        }
        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        ListNode dick = prev;
        while( curr !=null){ 
            int val= curr.val;
            if( badset.contains(val)){
                curr=curr.next;
               continue;
            }
            dick.next=new ListNode(val);
            dick=dick.next;
            curr=curr.next;
        } 
     return prev.next;
    
    }
}
