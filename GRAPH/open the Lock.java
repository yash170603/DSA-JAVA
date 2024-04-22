class Solution {
String target;
HashSet<String> vis;
HashSet<String> x;
    public int openLock(String[] deadends, String t) 
    {
        x = new HashSet<>(Arrays.asList(deadends));
        vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
      q.offer("0000");
      vis.add("0000");
      int ans=0;
      target = t;

      while(! q.isEmpty())
      {
        int size = q.size();

        for( int i =0;i<size;i++)
        {
            String curr = q.poll();
            if( curr.equals(target))
            {
                return ans;
            }
            for( int j=0;j<4;j++)
            {             
                
                for( int k=-1;k<=1;k +=2)
                {
                     char [] p= curr.toCharArray();
                   
                    p[j]= (char)((p[j] -'0'+k+10)%10+'0');
                    String h= new String(p);
                    if( !vis.contains(h) && !x.contains(h))
                    {
                        q.offer( h);
                        vis.add(h);
                    }
                }
            }
        }
        ans++;
      }
     return -1;

    }
}
