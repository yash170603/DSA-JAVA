import java.util.Arrays;
import java.util.Comparator;

class Solution {
    class Trie {
        Trie left; // represents bit 0
        Trie right; // represents bit 1
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        // Sort the nums array to facilitate the constraint nums[j] <= mi
        Arrays.sort(nums);
        
        // Add indexes to queries to help in output construction after sorting
        int[][] queriesWithIndex = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = i;
        }

        // Sort the queries based on the mi value
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[1]));

        Trie root = new Trie();
        int[] result = new int[queries.length];
        int index = 0;

        for (int[] query : queriesWithIndex) {
            int xi = query[0];
            int mi = query[1];
            int qIndex = query[2];

            // Insert nums into trie until the element is less than or equal to mi
            while (index < nums.length && nums[index] <= mi) {
                insert(root, nums[index]);
                index++;
            }

            // If no numbers are <= mi, then the answer is -1
            if (index == 0) {
                result[qIndex] = -1;
            } else {
                result[qIndex] = getMaxXor(root, xi);
            }
        }

        return result;
    }

    private void insert(Trie root, int num) {
        Trie node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (node.left == null) {
                    node.left = new Trie();
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Trie();
                }
                node = node.right;
            }
        }
    }

    private int getMaxXor(Trie root, int num) {
        Trie node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (node.right != null) {
                    maxXor += (1 << i);
                    node = node.right;
                } else {
                    node = node.left;
                }
            } else {
                if (node.left != null) {
                    maxXor += (1 << i);
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return maxXor;
    }
}
