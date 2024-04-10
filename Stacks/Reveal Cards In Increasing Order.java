import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] ans = new int[n];
        LinkedList<Integer> indexQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            indexQueue.offer(i);
        }
        
        for (int card : deck) {
            ans[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.offer(indexQueue.poll());
            }
        }
        
        return ans;
    }
}
