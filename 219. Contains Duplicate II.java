/* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k. */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Solution 1
        //Brute force approach
        //O(n^2) time complexity
        
        // int n = nums.length;
        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         if(nums[i] == nums[j] && Math.abs(i - j) <= k)
        //             return true;
        //     }
        // }
        // return false;
        
        //Solution 2
        //O(n) time and space complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
