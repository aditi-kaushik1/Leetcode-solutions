/* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space? */

class Solution {
    public void sortColors(int[] nums) {
        //Solution 1
        //Time Complexity - O(nlogn)
        //Arrays.sort(nums);
        
        //Solution 2
        //Counting sort
        //Time complexity - O(n) [Two pass solution]
//         int countOf0 = 0, countOf1 = 0, countOf2 = 0;
//         for(int x : nums) {
//             if(x == 0)
//                 countOf0++;
//             else if(x == 1)
//                 countOf1++;
//             else
//                 countOf2++;
//         }
        
//         int i = 0;
        
//         while(countOf0-- > 0)
//             nums[i++] = 0;
//         while(countOf1-- > 0)
//             nums[i++] = 1;
//         while(countOf2-- > 0)
//             nums[i++] = 2;
        
        //Solution 3
        //Time Complexity - O(n) [One Pass Solution]
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while(start < end && index <= end) {
            if(nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            }
            else if(nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }
            else
                index++;
        }
    }
}
