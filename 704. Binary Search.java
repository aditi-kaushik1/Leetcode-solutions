/* Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1. */

class Solution {
    public int search(int[] nums, int target) {
        //Iterative Solution
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = (left + right)/2;
            if(nums[middle] == target)
                return middle;
            else if(target < nums[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
        //return searchRecursive(nums, target, 0 , nums.length - 1);
    }
    
    //Solution 2
    //Recursive Solution
    // private int searchRecursive(int[] nums, int target, int left, int right) {
    //     if(right < left)
    //         return -1;
    //     int middle = (left + right)/2;
    //     if(nums[middle] == target)
    //         return middle;
    //     if(target < nums[middle])
    //         return searchRecursive(nums,target,left,middle - 1);
    //     return searchRecursive(nums,target,middle + 1,right);
    // }
}
