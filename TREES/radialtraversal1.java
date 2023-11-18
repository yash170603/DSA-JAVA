// The provided Java code implements a solution to find nodes at a distance K from a given target node in a binary tree.
//   The parentmap method creates a map that stores each node's parent in the tree.
//   The distanceK method uses this map to perform a breadth-first search (BFS) starting from the target node to find nodes at distance K from it.
// Here's a summary of the code functionality:
// parentmap(TreeNode root, Map<TreeNode, TreeNode> x): This method populates a map (x) that stores the parent of each node in the tree using a BFS approach.
// distanceK(TreeNode root, TreeNode target, int k): This method finds nodes at a distance K from the given target node in the binary tree.

// It initializes a map to keep track of visited nodes and performs BFS from the target node.
// While traversing, it tracks the distance from the target node and breaks when the distance becomes equal to K.
// Nodes at distance K are stored in an ArrayList (ans), which is returned as the final result.
// However, note that there are a few potential improvements and considerations that can be made in the code, such as handling edge cases, optimizing code, 
// and enhancing readability with better variable names and comments.

// Additionally, the current implementation does not handle cases where the value of K is greater than the depth of the tree or when the target node doesn't exist in the tree. 
// These scenarios might need to be addressed for a more robust solution.

// Certainly! Here are the complexities associated with the provided solution:

// Time Complexity:

// parentmap(TreeNode root, Map<TreeNode, TreeNode> x): This method traverses the entire tree using BFS. In the worst case, it visits every node once, taking O(N) time, where N is the number of nodes in the tree.

// distanceK(TreeNode root, TreeNode target, int k): This method performs a BFS starting from the target node and continues until a distance of K is reached or the traversal is complete.
//   In the worst-case scenario, where the target node is the root and all nodes need to be traversed (considering K is less than or equal to the number of nodes), this process takes O(N) time. However, in a balanced binary tree where the depth is log(N), the time complexity might be O(log N + K) because the BFS might not traverse the entire tree.

// Space Complexity:

// parentmap(TreeNode root, Map<TreeNode, TreeNode> x): The space complexity here is O(N), where N is the number of nodes in the tree. 
//   This is due to the usage of the HashMap x, which stores mappings for each node to its parent.

// distanceK(TreeNode root, TreeNode target, int k): The space complexity is also O(N) in the worst case.
//                                                                                  This is due to the usage of additional data structures such as HashMaps (visited and x) and the queue (qq).
//   In the worst case, the queue might store all nodes of the tree.

// These complexities might vary depending on the structure of the binary tree, such as its depth, balance, and the location of the target node.
//   In balanced binary trees, the time complexity might be lower due to early termination of BFS traversal, whereas in skewed or unbalanced trees, the worst-case complexities might be encountered.

//1st method
  
import java.util.*;
class Solution {
    public void parentmap(TreeNode root, Map<TreeNode,TreeNode> x)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            if( temp.left!= null)
            {
                x.put( temp.left, temp);
                q.offer(temp.left);
            }
             if( temp.right!= null)
            {
                x.put( temp.right, temp);
                q.offer(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k)
     {
        Map<TreeNode,TreeNode> x = new HashMap<>();
        parentmap(root, x);
        Map<TreeNode,Boolean> visited = new  HashMap<>();
        int distance =0;
        visited.put(target,true);
        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(target);

        while(!qq.isEmpty())
        {
            int size = qq.size();
            if(distance == k)
            break;
            distance++;

            for( int i=0; i< size;i++)
            {
                TreeNode t = qq.poll();
                if( t.left != null && visited.get(t.left) ==  null)
                {
                    qq.add(t.left);
                    visited.put(t.left, true);
                }
                 if( t.right != null && visited.get(t.right) ==  null)
                {
                    qq.add(t.right);
                    visited.put(t.right, true);
                }
                if(x.get(t) != null && visited.get(x.get(t)) == null)
                {
                    qq.add(x.get(t));
                    visited.put(x.get(t), true);
                }
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!qq.isEmpty())
        {
            TreeNode f = qq.poll();
            ans.add(f.val);
        }

        return ans;
    }
}
