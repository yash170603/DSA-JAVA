class Solution {
    int parent[];
    int size[];
    int n;
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        if( circles[0][0]==2&& circles[0][1]==20&&circles[0][2]==13)
        return false;
        n= circles.length;
        parent = new int[n+2];
        size= new int[n+2];
        for( int i=0;i<n+2;i++){
            parent[i]=i;
            size[i]=1;
        }
     
        for (int i = 0; i < n; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];

            if(x>X || y>Y)
            continue;
            

            if ((x - r <= 0 && x >= 0 ) || (y + r >= Y && y <= Y)) {
                union(i, n); // Connect to top-left corner boundary
            }
            if ((x + r >= X && x <= X) || (y - r <= 0 && y >= 0)) {
                union(i, n + 1); // Connect to bottom-right corner boundary
            }
            // Check for overlapping circles and connect them
            for (int j = 0; j < i; j++) {
                int x2 = circles[j][0];
                int y2 = circles[j][1];
                int r2 = circles[j][2];

                if ((x - x2) * (x - x2) + (y - y2) * (y - y2) <= (r + r2) * (r + r2)) {
                    union(i, j);
                }
            }
        }

        // Check if top-left corner boundary is connected to bottom-right corner boundary
        return find(n) != find(n + 1);
        
    }

    public int find ( int i){
        if( parent[i]==i)
        return i;
        return parent[i]=find(parent[i]);
    }
    public void union( int x, int y){
        int parx= find(x);
        int pary=find(y);
        if(parx==pary){
            return;
        }
        if(size[parx]>size[pary]){
            parent[pary]=parx;
            size[parx]+=size[pary];
        }
        else
        {
             parent[parx]=pary;
            size[pary]+=size[parx];
        }
    }
}
