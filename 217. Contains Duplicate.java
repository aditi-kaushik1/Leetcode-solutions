/* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Solution 1
        // Set<Integer> set = new HashSet<>();
        // for(int x : nums) {
        //     if(set.contains(x))
        //         return true;
        //     set.add(x);
        // }
        // return false;
        
        //Solution 2
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i] == nums[i + 1])
                return true;
        return false;
    }
}
