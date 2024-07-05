//bf
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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode node= head;
        node= node.next;
        ListNode ans = new ListNode(-1);
        ListNode dummy= ans;
        int cursum=0;  

        while( node !=null)
        {

            if( node.val !=0)
            {
                cursum+=node.val;
            }
            else
            {
                ListNode temp= new ListNode(cursum);
                dummy.next=temp;
                dummy=dummy.next;
                cursum=0;
                
            }
            node=node.next;
        }
        return ans.next;
    }
}



// better
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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode prev = head;
        ListNode pointer= head;
        ListNode ans = pointer;
       
        pointer=pointer.next;
        int cursum=0;
        while( pointer !=null)
        {
             cursum += pointer.val;
            if( pointer.val ==0)
            {  
                pointer.val=cursum;
                prev.next=pointer;
                prev=pointer;
                cursum=0;
            }
            pointer=pointer.next;
        }
        return ans.next;
    }
}
