/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. */

class Solution {
    //Solution 1
    /* Brute Force Algorithm:
    O(n^3) solution.
    First loop keeps a check of size of the sub array. 
    Next nested loop keeps a track of the starting index.
    Then put an if condition to check if that subarray can be made.
    Then, the next for loop calculates the sum. 
    Keep updating int ans = max(ans, sum). 
    Outside all for loops, write return ans. 
    Since it has 3 nested loops, hence time limit exceeded message is shown.
    
    Solution 2:
    Adjust the solution 1 a little. Instead of first focussing 
    on the number of elements in the subarray, focus on the starting index. 
    The solution becomes O(n^2) as earlier, 
    the same startinhg index was being accessed through different iterations.*/
    public int maxSubArray(int[] nums) {
        // int ans = Integer.MIN_VALUE;
        // int n = nums.length;
        // for(int numOfElements = 1; numOfElements <= n; numOfElements++) {
        //     for(int startingIndex = 0; startingIndex < n; startingIndex++) {
        //         if(startingIndex + numOfElements > n)
        //             break;
        //         int sum = 0;
        //         for(int i = startingIndex; i < startingIndex + numOfElements; i ++) {
        //             sum += nums[i];
        //         }
        //         ans = Math.max(sum,ans);
        //     }
        // }
        // return ans;
        
        //Solution 2:
        // int n = nums.length;
        // int ans = Integer.MIN_VALUE;
        // for(int startIndex = 0; startIndex < n; startIndex++) {
        //     int sum = 0;
        //     for(int numOfElements = 1; numOfElements <= n; numOfElements++) {
        //         if(startIndex + numOfElements > n)
        //             break;
        //         sum += nums[startIndex + numOfElements - 1];
        //         ans = Math.max(ans,sum);
        //     }
        // }
        // return ans;
        
        //Solution 3:
        //Kadane's algorithm!!
//         int currSum = nums[0];
//         int maxSum = nums[0];
//         for(int i = 1; i < nums.length; i++) {
//             currSum = Math.max(currSum + nums[i], nums[i]);
//             maxSum = Math.max(currSum, maxSum);
//         }
//         return maxSum;
        
        //Solution 4
        //Divide and conquer
//         return maxSubArrayHelper(nums, 0, nums.length - 1);
//     }
    
//     private int maxSubArrayHelper(int[] nums, int s, int e) {
//         if(s == e)
//             return nums[s];
//         int mid = s + (e - s)/2;
        
//         int leftSum = maxSubArrayHelper(nums, s, mid);
//         int rightSum = maxSubArrayHelper(nums, mid + 1, e);
//         int midSum = crossSum(nums, s, mid, e);
        
//         return Math.max(leftSum, Math.max(rightSum, midSum));
//     }
    
//     private int crossSum(int nums[], int s, int mid, int e) {
//         int lSum = 0;
//         int maxLeft = Integer.MIN_VALUE;
        
//         for(int i = mid; i >= s; i--) {
//             lSum += nums[i];
//             maxLeft = Math.max(lSum, maxLeft);
//         }
        
//         int rSum = 0;
//         int maxRight = Integer.MIN_VALUE;
        
//         for(int i = mid + 1; i <= e; i++) {
//             rSum += nums[i];
//             maxRight = Math.max(rSum, maxRight);
//         }
        
//         return maxLeft + maxRight;
//     }
// }
        
        //Solution 5
        
        class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sumOfWindow = nums[0];
        int ans = nums[0];

        while(true) {
            if(sumOfWindow < 0) {
                sumOfWindow -= nums[left];
                left++;
            }
            else {
                right++;
                if(right == nums.length)
                    break;
                sumOfWindow += nums[right];
                ans = Math.max(ans, sumOfWindow);
            }
            if(left > right) {
                right++;
                if(right == nums.length)
                    break;
                sumOfWindow += nums[right];
                ans = Math.max(ans, sumOfWindow);
            }
        }
        return ans;
    }
}
// nums = [-2,1,-3,4,-1,2,1,-5,4]
// left = 3
// right = 9
// sumOfWindow = 5
// ans = 6
// nums.length = 9
// ans = -2
// [-2] -> [] -> [1] -> [1, -3] -> [-3] -> [] -> [4] -> [4, -1] -> [4, -1, 2] -> [4, -1, 2, 1] ->
// [4, -1, 2, 1, -5] -> [4, -1, 2, 1, -5, 4]

// [-1, -2, -3]
//[-1] -> []
