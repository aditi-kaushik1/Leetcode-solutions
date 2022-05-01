/* There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).

Example 1:
Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1 */

class Solution {
    public int arraySign(int[] nums) {
        //Solution 1
//         int product = 1;
//         if(nums[0] != 0)
//             product = nums[0] / Math.abs(nums[0]);
//         if(nums[0] == 0)
//             return 0;
//         for(int i = 1; i< nums.length; i++) {
//             if(nums[i] == 0)
//                 return 0;
//             product = product * (Math.abs(nums[i])/nums[i]);
//         }
//         return (product == 1) ? 1 : -1;
        
        //Solution 2
        //Simpler, cleaner code
        int countOfNegativeNumbers = 0;
        for(int x : nums) {
            if(x == 0)
                return 0;
            if(x < 0)
                countOfNegativeNumbers++;
        }
        return (countOfNegativeNumbers % 2 == 0) ? 1 : -1;
    }
}
