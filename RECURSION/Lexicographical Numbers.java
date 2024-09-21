class Solution {

    private void solve(int curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }
        
        result.add(curr);  // Add current number to result
        
        // Generate the next number by appending digits 0 to 9
        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = curr * 10 + nextDigit;
            
            if (nextNum > n) {
                return;
            }
            
            solve(nextNum, n, result);  // Recursive call
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        // Start from numbers 1 to 9
        for (int num = 1; num <= 9; num++) {
            solve(num, n, result);
        }
        
        return result;  // Return the result list
    }
}
