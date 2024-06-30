//goal was to keep the  window size == k, 
//and return the top element 

import java.util.PriorityQueue;

class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int kk, int[] nums) {
        k = kk;
        minHeap = new PriorityQueue<>(k); // Min-heap to store the k largest elements

        // Add initial elements to the heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add the new value to the heap
        if (minHeap.size() < k) {
            minHeap.offer(val); // Directly add if the heap size is less than k
        } else if (val > minHeap.peek()) {
            // Only add the new value if it is larger than the smallest in the heap
            minHeap.poll(); // Remove the smallest
            minHeap.offer(val); // Add the new value
        }
        return minHeap.peek(); // The root of the heap is the kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
