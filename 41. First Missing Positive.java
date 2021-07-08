/* Given an unsorted integer array nums, find the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] <= 0 || nums[i] > n || nums[i] == i + 1)
                i++;
            else if(nums[nums[i] - 1] == nums[i])
                i++;
            else
                swap(nums, i, nums[i] - 1);
        }
        for(int j = 0; j < n; j++)
            if(nums[j] != j + 1)
                return j + 1;
        return n + 1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
