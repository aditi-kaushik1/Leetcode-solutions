/* You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 
Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000 */

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //Solution 1
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
        
           //Solution 2
//         int sum = 0;
//         for(int x : nums)
//             sum += x;
//         if(((sum - target) % 2 != 0) || (target > sum))
//             return 0;
        
//         int n = nums.length;
//         int s2 = (sum - target)/2;
        
//         int[][] t = new int[n + 1][s2 + 1];
//         for(int i = 0; i < n + 1; i++) {
//             for(int j = 0; j < s2 + 1; j++) {
//                 if(i == 0)
//                     t[i][j] = 0;
//                 if(j == 0)
//                     t[i][j] = 1;
//             }
//         }
        
//         for(int i = 1; i < n + 1; i++) {
//             for(int j = 1; j < s2 + 1; j++) {
//                 if((nums[i - 1] > j) || (nums[i - 1] == 0))
//                     t[i][j] = t[i - 1][j];
//                 else
//                     t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
//             }
//         }
        
//         int count = 0;
//         for(int x : nums)
//             if(x == 0)
//                 count++;
        
//         return (int)(Math.pow(2,count)) * t[n][s2];
    }
}
