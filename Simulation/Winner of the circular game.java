************************************************************** JAVA ***************************************************************/
//Approach 1: Brute Force (Simple Simulation)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        int i = 0; // Game starts from 1st player which is sitting at index 0 in arr

        while (arr.size() > 1) {
            int idx = (i + k - 1) % arr.size();
            arr.remove(idx);
            i = idx;
        }

        return arr.get(0);
    }
}


//Approach 2: Using Queue for Simulation
//T.C : O(n*k)
//S.C : O(n)
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        while (que.size() > 1) {
            for (int count = 1; count <= k - 1; count++) {
                que.add(que.poll());
            }
            que.poll();
        }

        return que.peek();
    }
}


//Approach 3: Using Recursion
//T.C : O(n)
//S.C : O(1), but note that it will take o(n) system stack space
class Solution {   //see neetcode for recursion , so goood explained.
    private int findWinnerIdx(int n, int k) {
        if (n == 1) {
            return 0; // index
        }

        int idx = findWinnerIdx(n - 1, k);
        idx = (idx + k) % n; // to find the original index in the original array

        return idx;
    }

    public int findTheWinner(int n, int k) {
        int resultIdx = findWinnerIdx(n, k);
        return resultIdx + 1;
    }
}


