class Solution {
    int n;
    long dp[][];

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        n = energyDrinkA.length;
        dp = new long[n][2]; // Updated to long type for larger values
        for (long[] arr : dp) {
            Arrays.fill(arr, -1); // Use Arrays.fill for long type
        }

        // Start from index 0 with either drink A or drink B
        long startWithA = solve(energyDrinkA, energyDrinkB, 0, 0);
        long startWithB = solve(energyDrinkA, energyDrinkB, 1, 0);

        // Return the maximum of starting with either drink
        return Math.max(startWithA, startWithB);
    }

    // prev indicates the previous drink taken: 0 for A, 1 for B
    public long solve(int[] a, int[] b, int prev, int index) {
        if (index >= n) return 0; // Base case: no more hours left

        if (dp[index][prev] != -1) return dp[index][prev]; // Memoization

        long sameDrink, switchDrink;
        if (prev == 0) {
            // Continue with A or switch to B
            sameDrink = a[index] + solve(a, b, 0, index + 1);
            switchDrink = (index + 1 < n) ? solve(a, b, 1, index + 2) + b[index + 1] : 0;
        } else {
            // Continue with B or switch to A
            sameDrink = b[index] + solve(a, b, 1, index + 1);
            switchDrink = (index + 1 < n) ? solve(a, b, 0, index + 2) + a[index + 1] : 0;
        }

        return dp[index][prev] = Math.max(sameDrink, switchDrink);
    }
}
