class Solution {
    public long wonderfulSubstrings(String word) {
        
        Map<Long, Long> mp = new HashMap<>();

        mp.put(0L, 1L);
        int cum_xor = 0;

        long result = 0;

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';

            cum_xor ^= (1 << shift);

            result += mp.getOrDefault((long) cum_xor, 0L);

            for (char ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';

                long check_xor = (cum_xor ^ (1 << shift));

                result += mp.getOrDefault(check_xor, 0L);
            }

            mp.put((long) cum_xor, mp.getOrDefault((long) cum_xor, 0L) + 1);
        }

        return result;
    }
}
