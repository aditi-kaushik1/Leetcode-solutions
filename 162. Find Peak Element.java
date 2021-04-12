/* A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks. */

class Solution {
    public int findPeakElement(int[] nums) {
        //Solution 1
        //Binary search on answer
        //O(log N) solution
//         if(nums.length == 1)
//             return 0;
//         int left = 0;
//         int right = nums.length - 1;
//         int mid;
//         int n = nums.length;
        
//         while(left <= right) {
//             mid = left + (right - left)/2;
//             if(mid == 0 && nums[0] > nums[1])
//                 return 0;
//             if(mid == n - 1 && nums[n-1] > nums[n-2])
//                 return n-1;
// if(mid > 0 && mid < n - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
//                 return mid;
//             else if(nums[mid] < nums[mid + 1])
//                 left = mid + 1;
//             else
//                 right = mid - 1;
//         }
//         return -1;
        
        //Solution 2
        //Linear scan
        //O(n) solution
        // if(nums.length == 1)
        //     return 0;
        // int n = nums.length;
        // if(nums[0] > nums[1])
        //     return 0;
        // if(nums[n-1] > nums[n - 2])
        //     return n-1;
        // for(int i = 1; i < n-1; i++) {
        //     if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
        //         return i;
        // }
        // return -1;
        
        //Solution 3
        //Linear scan
        //Beautiful code!!
        //Check leetcode solution page for explanation
        // for(int i = 0; i < nums.length - 1; i++)
        //     if(nums[i] > nums[i+1])
        //         return i;
        // return nums.length - 1;
        
        //Solution 4
        //Recursive binary search
        return recBinarySearch(nums,0,nums.length - 1);
    }
    
    public int recBinarySearch(int[] nums, int left, int right) {
        if(left == right)
            return left;
        int mid = left + (right - left)/2;
        if(nums[mid] > nums[mid + 1])
            return recBinarySearch(nums,left,mid);
        return recBinarySearch(nums,mid + 1,right);
    }
}
