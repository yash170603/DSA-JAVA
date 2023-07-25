
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //we will create a hashmap and put all the list1 values into that map lets do it.
       /* HashSet<ListNode> map=new HashSet<ListNode>();
        while(headA!=null){
            map.add(headA);
            headA=headA.next;
        }
        // we have successfully put all the values of linked list1 into map;
        //no we will just check
        while(headB!=null){
            if(map.contains(headB))
            return headB;
            headB=headB.next;
        }
        return null;*/
        // efficient solution
       /* ListNode dummy=headA;
        ListNode dummy1=headB;
        int l1=0,l2=0;
        while(headA!=null){
            l1++;
            headA=headA.next;
        }
        while(headB!=null){
            l2++;
            headB=headB.next;
        }
        int i=0;
        if(l2>l1){
            int c=l2-l1;
            while(i<c){
                dummy1=dummy1.next;
                i++;
            }
        }
          if(l1>l2){
            int c=l1-l2;
            while(i<c){
                dummy=dummy.next;
                i++;
            }
        }
        while(dummy!=null){
            if(dummy==dummy1)
            return dummy;
            dummy=dummy.next;
            dummy1=dummy1.next;
        }
        return null;*/
        /*The intuition behind the approach of finding the intersection point of two linked lists by adjusting their starting positions
        based on the difference in lengths is to ensure that both lists have the same number of nodes to traverse before reaching the intersection point.
        The key observation is that if two linked lists intersect at a certain node, all the subsequent nodes will be common in both lists.
        However, the nodes before the intersection point will differ in both lists. By aligning the starting positions of the two lists,
        we make sure that both pointers (dummy and dummy1) cover the same distance to reach the intersection point.*/


        
        // another solution
ListNode d1=headA;
ListNode d2=headB;
while((d1!=null)||(d2!=null)){
    if(d1==null)
    d1=headB;
    if(d2==null)
    d2=headA;
    if(d1==d2)
    return d1;
    d1=d1.next;
    d2=d2.next;
}
return null;
            


    }
}
