/* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed. */

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            if(nums[j] == val) {
                j--;
                continue;
            }
            
            else if(nums[i] == val) {
                swap(nums, i, j);
                i++;
            }
            else
                i++;
        }
        return j + 1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
