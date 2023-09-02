class Solution {


  ///dp se solve hoga, this sol passed 28/48 cases
    public boolean wordBreak(String s, List<String> wordDict)
     {
           boolean b = false;

       List < String > path= new ArrayList<>();
        List  < String> res = new ArrayList<>();

         partitionHelper(0,s,path,res);
       b= containsAllWords( res, wordDict);

       return b;



        
    }
    
     void partitionHelper(int index, String s, List < String > path,List < String > res) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
           
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                path.remove(path.size() - 1);
            
        }
    }

    boolean containsAllWords(List<String> res, List<String> wordDict) {
    for (String word : wordDict) {
        boolean found = false;
        for (String sentence : res) {
            if (sentence.contains(word)) {
                found = true;
                break; // Word found in one of the sentences, no need to continue searching
            }
        }
        if (!found) {
            return false; // Word not found in any sentence, return false
        }
    }
    return true; // All words found in at least one sentence
}
}
