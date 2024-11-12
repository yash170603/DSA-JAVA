import java.util.*;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price, and if prices are the same, by descending beauty
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];  // Sort by price
            else return b[1] - a[1];               // If prices are the same, sort by beauty
        });

        // Filter out items with duplicate prices, keeping only the highest beauty for each price
        List<int[]> uniqueItems = new ArrayList<>();
        int maxBeautySoFar = 0;
        for (int i = 0; i < items.length; i++) {
            // If it's the first item or a new price, add it to the list
            if (uniqueItems.isEmpty() || items[i][0] != uniqueItems.get(uniqueItems.size() - 1)[0]) {
                maxBeautySoFar = Math.max(maxBeautySoFar, items[i][1]);
                uniqueItems.add(new int[]{items[i][0], maxBeautySoFar});
            }
        }

        // Convert the list back to an array
        int[][] filteredItems = uniqueItems.toArray(new int[0][0]);

        // Result array for queries
        int[] result = new int[queries.length];
        
        // Process each query with binary search
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];

            // Binary search for the largest price <= query price
            int left = 0, right = filteredItems.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (filteredItems[mid][0] <= price) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }

            // If found, assign the max beauty for the largest available price <= query price
            result[i] = (right >= 0) ? filteredItems[right][1] : 0;
        }

        return result;
    }
}
