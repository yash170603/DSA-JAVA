/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
public class Solution1 {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) 
    {
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        ArrayList<Integer> x2 = new ArrayList<Integer>();
        inorder(root1,x1);
        inorder(root2,x2);
        x1.addAll(x2);
        HashSet<Integer> g = new HashSet<>();
        for(int l: x1)
        {
            g.add(l);
        }
 x2.clear();
 x2.addAll(g);
 Collections.sort(x2);

 return x2;

       
    }

    public static void inorder(TreeNode root, ArrayList<Integer> x)
    {
        if( root == null)
        return;

        inorder(root.left, x);
        x.add(root.val);
        inorder(root.right, x);    

    }
}
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating two separate trees with different root nodes
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right =  new TreeNode(5);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(6);
        root2.right =  new TreeNode(7);
              

        

        // Calling the mergeBST function
        List<Integer> mergedList = Solution1.mergeBST(root1, root2);

        // Printing the merged list
        System.out.println("Merged BST elements: " + mergedList);
    }
}







//offical
/*
    Time Complexity : O(N + M)
    Space Complexity : O(N + M)

    Where, 'N' and 'M' are the number of nodes in the first BST and the second BST respectively.

*/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Store the in-order traversal of tree1 in an array.
        List<Integer> temp1 = new ArrayList<>();
        storeInOrder(root1, temp1);

        // Store the in-order traversal of tree2 in an array.
        List<Integer> temp2 = new ArrayList<>();
        storeInOrder(root2, temp2);

        // Merge the two sorted arrays.
        List<Integer> answer = mergeSortedArrays(temp1, temp2);

        // Construct the balanced BST from this sorted array.
        return answer;
    }

    // Function to merge two sorted array/lists.
    public static List<Integer> mergeSortedArrays(List<Integer> arr1, List<Integer> arr2)
    {
        int i = 0, j = 0;
        List<Integer> arr = new ArrayList<>();

        // Traversing in both arrays.
        while (i < arr1.size() && j < arr2.size())
        {
            // Comparing array elements.
            if (arr1.get(i) < arr2.get(j))
            {
                arr.add(arr1.get(i));
                i++;
            }
            else
            {
                arr.add(arr2.get(j));
                j++;
            }
        }

        // Pushing rest elements.
        while (i < arr1.size())
        {
            arr.add(arr1.get(i));
            i++;
        }

        // Pushing rest elements.
        while (j < arr2.size())
        {
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }

    // Function to store the inorder traversal of tree in a list.
    public static void storeInOrder(TreeNode root, List<Integer> arr)
    {
        if (root != null)
        {
            storeInOrder(root.left, arr);
            arr.add(root.data);
            storeInOrder(root.right, arr);
        }
    }
}

// O(N + M), where ‘N’ and ‘M’ are the number of nodes in the first BST and the second BST respectively.
// We are storing the inorder traversal of both BST in separate arrays, 
//and the merged inorder traversal in another array of size ‘N’ + ‘M’. So the overall space complexity will be O(‘N’ + ‘M’)
