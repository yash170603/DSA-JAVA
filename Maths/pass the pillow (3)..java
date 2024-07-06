class Solution {
    public int passThePillow(int n, int time) {
        int chunks = time / (n - 1);
        return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
}



class Solution {
    public int passThePillow(int n, int time) {
        
        int pointer=1;
        boolean flag= false;

        while( time-->0)
        {
            if( flag==false)
            {
                pointer++;
            }
            else if( flag == true)
            {
                pointer--;
            }
            
            if(pointer<=1)
            {              
               flag=false;
            }
             if( pointer==n)
            {
                flag=true;
            }
        }

        return pointer;
    }
}
