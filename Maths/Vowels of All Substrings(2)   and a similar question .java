class Solution {
    public long countVowels(String word) {

         long totalSum = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                totalSum += (long) (i + 1) * (n - i);
            }
        }
        return totalSum;
    }
    public  boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}



// questuion was to maek teams as kis and lds

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

