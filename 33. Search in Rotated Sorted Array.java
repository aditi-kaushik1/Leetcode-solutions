/*There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4 

Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104*/

class Solution {
    public int search(int[] arr, int target) {
       int n = arr.length;
        int left = 0;
        int right = n - 1;
        int mid = -1;
        while(left <= right) {
            mid = left + (right - left)/2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                break;
            else if(arr[mid] >= arr[0])
                left = mid + 1;
            else
                right = mid - 1;
        }
       
        if(arr[mid] == target)
            return mid;
        
        left = (target >= arr[0]) ? 0 : mid + 1;
        right = (target >= arr[0]) ? mid - 1 : n - 1;
        
        if(arr[0] < arr[n - 1]) {
            left = 0;
            right = n - 1;
        }
        
        while(left <= right) {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
