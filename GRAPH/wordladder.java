class Pair{
    String  first;
    int count;
    Pair(String first,int count){
        this.first=first;
        this.count=count;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set =new HashSet<>(wordList);
        Queue<Pair> q=new LinkedList<>();
        System.out.println(set);
        q.offer(new Pair(beginWord,1));
        q.remove(beginWord);
        while(!q.isEmpty()){
        String word=q.peek().first;
        int steps=q.peek().count;
        q.poll();
        if(word.equals(endWord)){
            return steps;
        }
        for(int j=0;j<beginWord.length();j++){
        for(char i='a';i<='z';i++){
        char[] helper=word.toCharArray();
        helper[j]=i;
        String str=new String(helper);
        if(set.contains(str)){
            q.offer(new Pair(str,steps+1));
            set.remove(str);

        }
        }
        }



        }


return 0;
    }
}
