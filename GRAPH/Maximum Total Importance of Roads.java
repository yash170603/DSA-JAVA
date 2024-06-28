//better class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for (int[] road: roads) {
            ++freq[road[0]];
            ++freq[road[1]];
        }
        Arrays.sort(freq);

        long importanceSum = 0;
        for (int i = 0; i< n; ++i) {
            importanceSum += freq[i] * (i + 1L);
        }

        return importanceSum;
    }
}
//brute
class Solution {
    public long maximumImportance(int n, int[][] edges) {
        

        int e []= new int [n]; // node[freq]
        for( int arr[]:edges)
        {
            e[arr[0]]++;
            e[arr[1]]++;
        }
        PriorityQueue<node> q = new PriorityQueue<>((a,b)-> (b.y-a.y));
        for( int i=0;i< n; i++) //pushing node,freq
        {
            int node = i;
            int freq = e[i];
            q.offer(new node(node,freq));
        }
        // ab sbse high freq wala niklega aur use n assign kro and n-- krte jao,aur e mei dlao
        // then uske baad edges mei firse iterate kro auru dono edges[o] aur edges[1] ko add krdo
         int k=n;
        while(!q.isEmpty())
        {
            node temp= q.poll();
            int NODE= temp.x;
            int val= k;
            e[NODE]=val;
            k--;
        }
      long ans=0;
        for(int p[]:edges)
        {
            ans+= ( e[p[0]]+e[p[1]]);

        }

        return ans;
    }
}

class node{
    int x,y;
    node(int x, int y)// node, frequency
    {
        this.x=x;
        this.y=y;
    }
}
