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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev= head;
        ListNode curr = head;
        curr= curr.next;
        int cindex=1;
        List<Integer> poss= new ArrayList();
        int min= Integer.MAX_VALUE;
        while( curr.next != null)
        {
            if((curr.val<prev.val && curr.val<curr.next.val )|| (curr.val>prev.val&&curr.val>curr.next.val))
            {
                poss.add(cindex+1);
                if( poss.size()>=2)
                { 
                    int diff =  poss.get( poss.size()-1)-  poss.get( poss.size()-2);
                    if( diff<min)
                    {
                        min=diff;
                    }
                }
            }
            curr=curr.next;
            prev=prev.next;
            cindex++;
        }
         if( poss.size()==0 || poss.size()<2)
         return new int[]{-1,-1};
        int max= poss.get(poss.size()-1)-poss.get(0);
        return new int []{min,max};

    }
}
