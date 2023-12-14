//1st
/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void inorder(TreeNode root, List < Integer > inorderArray)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, inorderArray);

        inorderArray.add(root.data);

        inorder(root.right, inorderArray);
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // To store the inorder traversal of the BST.
        List<Integer> inorderArray = new ArrayList<>();
        inorder(root, inorderArray);
        int predecessor = -1, successor = -1;

        // Finding predecessor.
        for (int i = 0; i < inorderArray.size(); i++)
        {
            if (inorderArray.get(i) < key)
            {
                predecessor = inorderArray.get(i);
            }
        }

        // Finding successor.
        for (int i = inorderArray.size() - 1; i >= 0; i--)
        {
            if (inorderArray.get(i) > key)
            {
                successor = inorderArray.get(i);
            }
        }

        List<Integer> sol = new ArrayList<>();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
}





//2nd
/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        int predecessor = -1;
        int successor = -1;

        // Initializing temporary node with head.
        TreeNode temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key > temp.data)
            {
                // Updating predecessor.
                predecessor = temp.data;
                temp = temp.right;
            }
            else
            {
                temp = temp.left;
            }
        }

        temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key >= temp.data)
            {
                temp = temp.right;
            }
            else
            {
                // Updating successor.
                successor = temp.data;
                temp = temp.left;
            }
        }

        List< Integer > sol = new ArrayList <> ();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
}
