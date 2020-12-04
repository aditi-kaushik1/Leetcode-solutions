/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1]. */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*Solution 1*/
        /*Using nested for loop, hence time complexity is O(n^2)
        // for(int  i = 0; i < nums.length; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[i] + nums[j] == target)
        //             return new int[]{i,j};
        //     }
        // }
        // return new int[0];
        
        /*Solution 2*/
        //Two pass HashTable
        //Check leetcode solution section for explanation
        Map<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement) };
            }
        }
        return new int[0];
        
        /*Solution 3*/
        //One pass HashTable*/
        //Check leetcode solution section for explanation
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0 ; i < nums.length; i++){
        //     int complement = target - nums[i];
        //     if(map.containsKey(complement) && map.get(complement) != i)
        //         return new int[]{i,map.get(complement)};
        //     map.put(nums[i], i);
        // }
        // throw new IllegalArgumentException("No two sum solution");
    }
}
