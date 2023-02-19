class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Double> set = new HashSet<>();
        for(int x : nums) {
            set.add((double)x);
        }
        int i = 0;
        while(Math.pow(2, i) <= Math.pow(10,9)*2) {
            if(!set.contains(Math.pow(2,i)))
                return (int)Math.pow(2, i);
            i++;
        }
        return 1;
    }
}
