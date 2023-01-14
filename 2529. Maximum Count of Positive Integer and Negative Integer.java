class Solution {
    public int maximumCount(int[] nums) {
        int numOfZeroes = 0;
        int neg = 0;
        int pos = 0;
        for(int i : nums) {
            if(i == 0)
                numOfZeroes++;
            else if(i < 0)
                neg++;
            else
                pos++;
        }
        return Math.max(pos, neg);
    }
}
