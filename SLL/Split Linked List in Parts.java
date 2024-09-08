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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        ListNode temp=head;
        int count =0;
        while( curr != null){
            count++;
            curr=curr.next;
        }
       ListNode[] ans= new ListNode[k];
        int  avg_size= count/k;
        int remainder = count%k;
        int index=0;
        if( remainder!=0){
            while( remainder-->0){
                ListNode c= temp;
                ListNode kid=temp;
                ListNode neg= new ListNode(-1);
                neg.next=temp;
                int val=0;
                while( val<avg_size+1 && kid!=null){
                    kid=kid.next;
                    temp=temp.next;
                    neg=neg.next;
                    val++;
                } 
                neg.next=null;

                ans[index]=c;
                index++;
            }
        }

        while( temp!=null){
            ListNode f=temp;
            ListNode child=temp;
            ListNode nigga= new ListNode();
            nigga.next=temp;
            int value=0;
            while( value< avg_size){
                child=child.next;
                temp=temp.next;
                nigga=nigga.next;
                value++;
            }
            nigga.next=null;
            ans[index]=f;
            index++;
        }
      
        return ans;
    }
}
