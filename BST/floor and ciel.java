  static int findFloor(Node root, int input) {
        int floor = -1;
        while (root != null) {
            if (root.data == input)
                return input;
            else if (root.data < input) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }



public class CeilInBST {
    static int findCeil(Node root, int input) {
        int ceil = -1;
        
        while (root != null) {
            if (root.data == input) {
                return input;  // If input is found in the tree, return it as ceil.
            } else if (root.data < input) {
                root = root.right;  // Move to the right subtree if input is greater than current node's data.
            } else {
                ceil = root.data;   // Mark ceil to be current node's data.
                root = root.left;   // Move to the left subtree to find a closer ceil value.
            }
        }
        
        return ceil;  // Return computed ceil value.
    }
