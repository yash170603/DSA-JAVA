
public class detectstartpoint {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // Move tortoise one step and hare two steps
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // Check if the hare meets the tortoise
            if (tortoise == hare) {
                break;
            }
        }

        // Check if there is no cycle
        if (hare == null || hare.next == null) {
            return null;
        }

        // Reset either tortoise or hare pointer to the head
        hare = head;

        // Move both pointers one step until they meet again
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        // Return the node where the cycle begins
        return tortoise;
    }
}



/*public class Solution {    this is hashset method
    public ListNode detectCycle(ListNode head) {
        // Initialize an empty hash set
        HashSet<ListNode> nodesSeen = new HashSet<>();
        
        // Start from the head of the linked list
        ListNode node = head;
        while (node != null) {
            // If the current node is in nodesSeen, we have a cycle
            if (nodesSeen.contains(node)) {
                return node;
            } else {
                // Add this node to nodesSeen and move to the next node
                nodesSeen.add(node);
                node = node.next;
            }
        }

        // If we reach a null node, there is no cycle
        return null;
    }
}*/
