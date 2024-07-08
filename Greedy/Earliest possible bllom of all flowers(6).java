// The problem is to determine the earliest possible day when all plants will be fully bloomed.
//   We have two arrays: `plantTime` which indicates the number of days it takes to plant each seed, 
//   and `growTime` which indicates the number of days it takes for each plant to grow and bloom after it has been planted. 

// ### Key Intuition and Strategy

// 1. **Order of Planting Matters**: The key insight is that the order in which you plant the seeds significantly affects the total bloom time. 
//   Specifically, seeds with longer grow times should be prioritized and planted earlier to minimize the overall bloom time.

// 2. **Why Sort by Grow Time?**:
//    - Seeds with longer grow times delay the total bloom time more if planted later.
//   By planting seeds with longer grow times first, we ensure that their longer duration does not excessively delay the bloom time of subsequent seeds.
//    - This strategy is a form of a greedy algorithm where we make a local optimal choice (planting the seed with the longest grow time first) with the hope that it leads to a globally optimal solution.

// ### Steps to Solve the Problem

// 1. **Pair and Sort**: Create pairs of plant and grow times for each seed. Then, sort these pairs in descending order based on grow time.
// 2. **Accumulate Plant Times**: Iterate through the sorted list, and for each seed, keep a running total of the days required to plant the seeds (`prevPlantDays`).
// 3. **Calculate Bloom Time**: For each seed, calculate the bloom time as the sum of the accumulated plant time and the seed's grow time. Keep track of the maximum bloom time encountered.
// 4. **Result**: The maximum bloom time across all seeds is the earliest day on which all seeds will have bloomed.

// ### Detailed Walkthrough

// 1. **Initialization**: 
//    - Create a list of pairs from the input arrays.
//    - Sort this list in descending order by grow time.

// 2. **Planting and Bloom Calculation**:
//    - Initialize `prevPlantDays` to keep track of the cumulative days spent planting seeds.
//    - Initialize `maxBloomDays` to keep track of the latest bloom day encountered.
//    - For each seed in the sorted list:
//      - Add the current seed's plant time to `prevPlantDays`.
//      - Calculate the current seed's bloom time as `prevPlantDays + currGrowTime`.
//      - Update `maxBloomDays` if the current bloom time is greater than the previously recorded maximum bloom time.

### Code Explanation

```java
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        // Create a list of pairs {plantTime[i], growTime[i]}
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[]{plantTime[i], growTime[i]});
        }
        
        // Sort the grow_plant_times of seeds by their growTime in descending order.
        // It makes sense to plant the seed with maximum growTime first.
        vec.sort((a, b) -> b[1] - a[1]);
        
        int prevPlantDays = 0;
        int maxBloomDays = 0;
        
        for (int[] pair : vec) {
            int currPlantTime = pair[0];
            int currGrowTime = pair[1];
            
            // Adding the plant time of ith seed to the plant times of preceding seeds.
            // It would take prevPlantDays amount of time to actually plant the ith seed.
            prevPlantDays += currPlantTime;
            
            // Bloom time of ith seed = total plant time of ith seed + grow time of ith seed.
            int currPlantBloomTime = prevPlantDays + currGrowTime;
            
            // Update the maximum bloom days
            maxBloomDays = Math.max(maxBloomDays, currPlantBloomTime);
        }
        
        return maxBloomDays;
    }
}
```

### Summary

By sorting the seeds based on their grow time in descending order and accumulating the planting times,
  we ensure that seeds with longer grow times are prioritized, thus minimizing the overall bloom time.
  This greedy strategy leverages the intuition that delaying seeds with long grow times has a more significant
  negative impact on the final result compared to delaying those with shorter grow times.
