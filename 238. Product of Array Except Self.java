/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? 
(The output array does not count as extra space for space complexity analysis.) */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Check out Nick White's solution
        //Solution 1
        //O(n) extra space
//         int n = nums.length;
//         int[] leftProduct = new int[n];
//         int[] rightProduct = new int[n];
        
//         leftProduct[0] = 1;
//         rightProduct[n - 1] = 1;
        
//         int[] answer = new int[n];
        
//         for(int i = 1; i < n; i++) {
//             leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
//         }
        
//         for(int i = n - 2; i >= 0; i--) {
//             rightProduct[i] = nums[i + 1] * rightProduct[i+1];
//         }
        
//         for(int i = 0; i < n; i++) {
//             answer[i] = leftProduct[i] * rightProduct[i];
//         }
//         return answer;
        
        //Solution 2
        //Optimised solution
        //O(n) time complexity and O(1) space used
        int n= nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        int r = 1;
        
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        
        return ans;
        
        //Solution 3
        //By taking product
        //Deal with the cases of 0 separately
//         int product = 1;
        
//         for(int x : nums)
//             product *= x;
        
//         int[] answer = new int[nums.length];
        
//         int count = 0;
        
//         for(int x : nums) {
//             if(x == 0)
//                 count++;
//         }
//         if(count > 1)
//             return answer;
//         int index = -1;
        
//         if(count == 1) {
//             product = 1;
//             for(int i = 0; i < nums.length; i++)
//                 if(nums[i] == 0)
//                     index = i; 
//             for(int i = 0; i < nums.length; i++)
//                 if(nums[i] != 0)
//                     product *= nums[i];
//             System.out.println(product);
//             answer[index] = product;
//             return answer;
//         }
        
//         for(int i = 0; i < nums.length; i++) {
//             answer[i] = product/nums[i];
//         }
//         return answer;
        
        //Solution 4
        ///Nested for loop
        //Time limit exceeded
        // int[] answer = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     answer[i] = 1;
        // }
        // int product = 1;
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j < nums.length; j++) {
        //         if(i != j)
        //             product *= nums[j];
        //     }
        //     answer[i] = product;
        //     product = 1;
        // }
        // return answer;
    }
}
