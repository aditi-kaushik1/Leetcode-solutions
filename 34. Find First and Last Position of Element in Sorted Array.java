/* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity? */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Solution 1
        //Binary Search
        //O(n) time complexity
        int left = 0;
        int right = nums.length - 1;
        int resFirst = -1;
        int resLast = -1;
        int middle = 0;
        
        while(left <= right) {
            middle = left + ((right - left)/2);
            
            if(target == nums[middle]) {
                resFirst = middle;
                right = middle - 1;
            }
            else if(target < nums[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        
        left = 0;
        right = nums.length - 1;
        
        while(left <= right) {
            middle = left + ((right - left)/2);
            
            if(target == nums[middle]) {
                resLast = middle;
                left = middle + 1;
            }
            else if(target > nums[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }
        return new int[]{resFirst,resLast};
        
        //Solution 2
        //Brute Force
        //O(n) solution
        // int firstOccur = -1;
        // int lastOccur = -1;
        // for(int i = 0; i < nums.length; i++) {
        //     if(firstOccur == -1 && nums[i] == target)
        //         firstOccur = i;
        //     if(nums[i]==target && ( i == nums.length - 1 || nums[i+1] != target))
        //         lastOccur = i;
        // }
        // return new int[]{firstOccur,lastOccur};
    }
}
