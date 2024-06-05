class Solution {
    public List<String> commonChars(String[] words) {
        
       List<String> ans = new ArrayList<>();

       int arr[]= new int [26];
       String s = words[0];
       char ch []= s.toCharArray();
       for( char x : ch)
       {
         arr[x-'a']++;
       }

       for( int i =1;i<words.length;i++)
       {
           String s1 = words[i];
           char c2 []= s1.toCharArray();
           int temp[]= new int [26];
           for( char d: c2)
           {
            temp[d-'a']++;
           }
           compare (arr,temp);
       }

       for(int t =0;t<26;t++ )
       {
        int freq = arr[t];
        while( freq-->0)
        {
            char gg = (char)(97+t);
           String g = Character.toString(gg);
            ans.add(g);
        }
       }
           
           return ans;
    }


    public void  compare(int arr[], int temp[])
    {
       for( int i =0;i<26;i++)
       {
           if( arr[i] == temp[i] || temp[i]==0|| temp[i]<arr[i])
           {
            arr[i]=temp[i];
           }
           else
           {
            continue;
           }
       }
    }
}

