/* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 */

class Solution {
    public void moveZeroes(int[] nums) {
        //Solution 1
        /* If instead of copying each element, you simply write nums = ans,
        it will not work, because in java, arrays are passed by value, 
        not reference, so the copy of the array gets changed, 
        but the original array remains unaltered.
        If the array would have been declared at the class level,
        then changes in the array would have been reflected. */
        //Space complexity : O(n)
        //Time complexity : O(n)
        
        // int[] ans = new int[nums.length];
        // int j = 0;
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] != 0)
        //         ans[j++] = nums[i];
        // }
        // for(int i = 0; i < nums.length; i++)
        //     nums[i] = ans[i];
        
        //Solution 2
        //Reference video : https://www.youtube.com/watch?v=1PEncepEIoE
        //Space complexity : O(1)
        //Time complexity : O(n)
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }
        for(int i = index; i < nums.length; i++)
            nums[i] = 0;
        
        //Solution 3
//         int index = 0;
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] != 0) {
//                 swap(nums, i, index);
//                 index++;
//             }
//         }
//     }
    
//     public void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
    }
}
