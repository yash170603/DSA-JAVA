import java.util.*;
import java.io.*;

class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    public Node addNode(Node head) {
        // Function to add 1 to the linked list
        Node reverseHead = reverseLinkedList(head);
        Node current = reverseHead;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;

            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                break;
            }

            current = current.next;
        }

        return reverseLinkedList(reverseHead);
    }

    // Function to reverse a linked list
    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
