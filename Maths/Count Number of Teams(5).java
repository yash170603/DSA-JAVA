class Solution {
    int n;

    public int numTeams(int[] rating) {
        n = rating.length;
        int totalTeams = 0;

        // Iterate through each soldier
        for (int j = 0; j < n; j++) {
            // Count increasing subsequences ending at j
            totalTeams += countIncreasing(j, rating);
            // Count decreasing subsequences ending at j
            totalTeams += countDecreasing(j, rating);
        }

        return totalTeams;
    }

    // Recursive function to count increasing subsequences ending at index j
    private int countIncreasing(int j, int[] rating) {
        int count = 0;

        for (int i = 0; i < j; i++) {
            if (rating[i] < rating[j]) {
                // Count the number of valid subsequences starting at i and ending at j
                count += countPairs( j, rating, true);
            }
        }

        return count;
    }

    // Recursive function to count decreasing subsequences ending at index j
    private int countDecreasing(int j, int[] rating) {
        int count = 0;

        for (int i = 0; i < j; i++) {
            if (rating[i] > rating[j]) {
                // Count the number of valid subsequences starting at i and ending at j
                count += countPairs( j, rating, false);
            }
        }

        return count;
    }

    // Recursive function to count pairs (i, k) such that
    // (rating[i] < rating[j] < rating[k]) for increasing
    // (rating[i] > rating[j] > rating[k]) for decreasing
    private int countPairs( int j, int[] rating, boolean isIncreasing) {
        int count = 0;

        for (int k = j + 1; k < n; k++) {
            if (isIncreasing && rating[j] < rating[k]) {
                count++;
            } else if (!isIncreasing && rating[j] > rating[k]) {
                count++;
            }
        }

        return count;
    }
}





there is another appraoch as in ques 2..
   Count Number of Teams

  class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        for (int j = 1; j < n - 1; j++) {
            int countSmallerLeft = 0;
            int countLargerLeft = 0;
            int countSmallerRight = 0;
            int countLargerRight = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    countSmallerLeft++;
                } else if (rating[i] > rating[j]) {
                    countLargerLeft++;
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[j] < rating[k]) {
                    countLargerRight++;
                } else if (rating[j] > rating[k]) {
                    countSmallerRight++;
                }
            }

            teams += (countLargerLeft * countSmallerRight) + (countSmallerLeft * countLargerRight);
        }

        return teams;
    }
}
