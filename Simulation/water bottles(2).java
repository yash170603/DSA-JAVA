class Solution {
    public int numWaterBottles(int bottles, int size) {
        
        int ans =0;
        while( bottles >=size)
        {
            int firstChunk=  bottles/size;
            int bottlesDrank= firstChunk*size;
            ans+=bottlesDrank;
            bottles-=bottlesDrank;
            bottles+=firstChunk;
        }
        return ans+bottles;
    }
}
