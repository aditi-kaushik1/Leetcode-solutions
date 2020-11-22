/*Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		// Total numbers of possible subsets is 2^N 
        
        //SPECIAL CASE FOR DUPLICATES !!!!!!!
        // nums =  java.util.stream.IntStream.of(nums).distinct().toArray();
        
        int N = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // We start counting subsets numers from ..0000, ...000001, ....000010 
		// where a set bit indicates that element is picked up, 
        //and unset element indicates element at that position is skipped
        for (int i =0; i<N; i++) {
            //Declare this list inside for loop because it changes in every iteration.
            List<Integer> subset = new ArrayList<>();
            for (int j=0; j<nums.length; j++) {
        // Check if jth bit of i is set, then element at index is part of our current subset
                if ( (i & (1<<j)) !=0)
                    subset.add(nums[j]);
            }
            result.add(subset);
        }
        return result;
}
}
