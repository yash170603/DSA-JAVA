class Solution {   // needs maximum rectangle from histogram
    int  [] prevarr;
    public int maximalRectangle(char[][] matrix) {
         
         if ( matrix.length ==1 && matrix[0].length ==1)
         {
            return Character.getNumericValue(matrix[0][0]);
         }
         if( matrix.length == 1 && matrix[0].length !=1)
         {
            int l =  matrix[0].length;
            int temp [] = new int[l];
            for( int u=0;u<l;u++)
            {
               temp[u] = Character.getNumericValue(matrix[0][u]);
            }

            return solve( temp);
         }
 //above are the edges cases
        int n = matrix.length;
        int m = matrix[0].length;
        prevarr = new int[m];
        for( int  k =0;k<m;k++)
        {
            prevarr[k]= Character.getNumericValue(matrix[0][k]);
        }
        int ans =0;
        ans = Math.max(ans,solve(prevarr)); // what if the 1st array is the ans;

      

        for( int i =1;i<n;i++)
        {
             int currarr []= new int[m];
            for( int j =0;j<m;j++)
            {
                 int curr = Character.getNumericValue(matrix[i][j]);
                
                 if( curr !=0)
                 {
                    currarr[j] = curr + prevarr[j];
                 }
                 else if(curr ==0)
                 {
                    currarr[j]=0;  // oopr ka sum kuch bhi ho agar base 0 hai toh poora tower zero ho jaega
                 }
            }

            ans = Math.max(ans, solve(currarr));
            System.arraycopy(currarr, 0, prevarr, 0, prevarr.length);
        }

        return ans;
    }

     public int solve(int[] heights) {
        int n = heights.length, area = 0;

        // Find the next smaller left -->
        Stack<Integer> s = new Stack<>();
        int[] nsl = new int[n];
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                nsl[i] = s.peek();
            } else {
                nsl[i] = -1;
            }

            s.push(i);
        }


        // Find the next smaller right -->
        s = new Stack<>();
        int[] nsr = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(!s.isEmpty()) {
                nsr[i] = s.peek();
            } else {
                nsr[i] = n;
            }

            s.push(i);
        }


        // Calculating the area of Histogram -->
        for(int i = 0; i < n; i++) {
            int hei = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = hei * width;
            area = Math.max(area, currArea); 
        }

        return area;
    }
}
