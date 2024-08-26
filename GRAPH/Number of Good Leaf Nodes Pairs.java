class Solution {
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) { // Leaf node
            leafNodes.add(root);
        }

        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }

        makeGraph(root.left, root, adj, leafNodes);
        makeGraph(root.right, root, adj, leafNodes);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>(); // Graph
        Set<TreeNode> leafNodes = new HashSet<>(); // Leaf nodes

        makeGraph(root, null, adj, leafNodes);

        int count = 0; // Count of good node pairs

        for (TreeNode leaf : leafNodes) {
            // Perform BFS and see if you can find other leaf nodes within distance
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leaf);
            visited.add(leaf);

            for (int level = 0; level <= distance; level++) { // Only go till level <= distance
                int size = queue.size();
                while (size-- > 0) { // Process level
                    TreeNode curr = queue.poll();

                    if (curr != leaf && leafNodes.contains(curr)) {
                        count++;
                    }

                    for (TreeNode neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return count / 2;
    }
}



//Approach-2 (Using DFS)
//T.C : O(n*m^2) where m = number of leaf nodes
//S.C : O(n*m) where m = number of leaf nodes
public class Solution {

    public List<Integer> solve(TreeNode root, int distance, int[] goodLeafNodes) {
        if (root == null) {
            List<Integer> emptyList = new ArrayList<>();
            emptyList.add(0);
            return emptyList;
        }

        if (root.left == null && root.right == null) {
            List<Integer> leafList = new ArrayList<>();
            leafList.add(1);
            return leafList;
        }

        List<Integer> leftDistances = solve(root.left, distance, goodLeafNodes);
        List<Integer> rightDistances = solve(root.right, distance, goodLeafNodes);

        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l != 0 && r != 0 && l + r <= distance) {
                    goodLeafNodes[0]++;
                }
            }
        }

        List<Integer> currentDistances = new ArrayList<>();
        for (int ld : leftDistances) {
            if (ld != 0 && ld + 1 <= distance) {
                currentDistances.add(ld + 1);
            }
        }

        for (int rd : rightDistances) {
            if (rd != 0 && rd + 1 <= distance) {
                currentDistances.add(rd + 1);
            }
        }

        return currentDistances;
    }

    public int countPairs(TreeNode root, int distance) {
        int[] goodLeafNodes = new int[1];
        solve(root, distance, goodLeafNodes);
        return goodLeafNodes[0];
    }
}
