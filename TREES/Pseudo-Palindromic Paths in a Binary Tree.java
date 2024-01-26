/****************************************************** JAVA ******************************************************/
//Approach-1 (Simple and straight forward)
//T.C : O(n)
//S.C : O(1) (I am ignoring stack recursive space, else S.C  will be O(height of tree))
class Solution {
    private int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] temp = new int[10];
        solve(root, temp);
        return result;
    }

    private void solve(TreeNode root, int[] temp) {
        if (root != null) {
            temp[root.val]++;

            if (root.left == null && root.right == null) {
                int oddFreq = 0;
                for (int i = 1; i <= 9; i++) {
                    if (temp[i] % 2 != 0) {
                        oddFreq++;
                    }
                }

                result += oddFreq <= 1 ? 1 : 0;
            }

            solve(root.left, temp);
            solve(root.right, temp);

            temp[root.val]--;
        }
    }
}


//Approach-2 (Using bit magic)
//T.C : O(n)
//S.C : O(1) (I am ignoring stack recursive space, else S.C  will be O(height of tree))
class Solution {
    private int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        solve(root, 0);
        return result;
    }

    private void solve(TreeNode root, int temp) {
        if (root != null) {
            temp = temp ^ (1 << root.val); // path = 2->3->3, temp initi=0; for 2, temp = 0100, for 3 temp = 0100^1000(1<<3)= 1100, for 3 again ,temp = 1100^1000=0100, states only 1 bit is active at 2 second 
                                          // position i.e 2 occurs only once as all other comes even number of times and get cancel by xorr,

            if (root.left == null && root.right == null) {
                if ((temp & (temp - 1)) == 0) {  

                   // now thr final temp = 0100 is checke if it is odd occurence by checking it as power of 2, as in all elements of power of 2, only 1 bit is active
                    result++;
                }
            }

            solve(root.left, temp);
            solve(root.right, temp);
        }
    }
}
