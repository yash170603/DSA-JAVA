class Solution {
    class trie{
        trie left;//0
        trie right;//1
    }
    public int findMaximumXOR(int[] nums) {
        
        trie root= new trie();
        for( int x: nums)
        {
            create(root,x);
        }
        int res= 0;
        for(int l:nums)
        {
            res= Math.max(res,max(root,l));
        }
        return res;
    }

    public void create( trie head, int val)
    {
        trie pointer= head;
        for(int i = 31;i>=0;i--)
        {
            int bit = ( val>>i)&1;
            if( bit ==1) // go to right will creating
            {
                if(pointer.right == null)
                pointer.right= new trie();
                pointer=pointer.right;

            }
            else
            {
                if(pointer.left==null)
                pointer.left=new trie();
                pointer=pointer.left;
            }
        }
    }

    public int max(trie root, int val)
    {
        int ans=0;
        trie point= root;
        for(int i=31;i>=0;i--)
        {
            int bit = (val>>i)&1;
            if( bit ==0)// want to go right
            {
                if(point.right !=null )
                {
                    ans+=Math.pow(2,i);
                    point=point.right;
                }
                else
                point=point.left;
            }
            else
            {
                if(point.left!=null)
                {
                    ans+=Math.pow(2,i);
                    point=point.left;
                }
                else
                point=point.right;
            }
        }
        return ans;
    }
}
