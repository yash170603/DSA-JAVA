class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        HashSet<String> dictSet = new HashSet<>(dictionary);

        String[] arr = sentence.split(" ");
        for (String s : arr) {
            boolean flag = false;
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dictSet.contains(prefix)) {
                    ans.append(" ").append(prefix);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                ans.append(" ").append(s);
        }

        return ans.substring(1);
    }
}
