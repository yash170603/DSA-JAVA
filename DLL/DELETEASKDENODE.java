class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        // Handle the case where the list is empty
        if (head == null) {
            return null;
        }

        // Handle the case where the head node needs to be removed
        while (head != null && head.data == k) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }

        Node current = head;

        // Iterate through the linked list to remove occurrences of 'k'
        while (current != null) {
            if (current.data == k) {
                // Link the previous node to the next node to skip the current node
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }

        return head;
    }
}
