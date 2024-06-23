class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

class GfG {
    Node flatten(Node root) {
        if (root == null) {
            return root;
        }
        return solve(root);
    }
    
    public Node solve(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node returned = solve(head.next);
        Node merged = merge(head, returned);
        
        return merged;
    }
    
    public Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.bottom = l1;
                l1 = l1.bottom;
            } else {
                res.bottom = l2;
                l2 = l2.bottom;
            }
            res = res.bottom;
            res.next = null; // Ensure next is set to null
        }

        // Attach the remaining nodes, if any
        if (l1 != null) {
            res.bottom = l1;
        } else {
            res.bottom = l2;
        }
        
        return dummy.bottom;
    }
}
