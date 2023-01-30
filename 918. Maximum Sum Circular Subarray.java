class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //Solution 1
        /* Passed 106 out of 11 test cases. 
        Consider windows and find the sum in them, if the sum of the numbers in window become negative, 
        start removing elements from the left end of the window. Change the array to twice it's size.
        Make sure the window size doesn't exceed the intial array size.
        Make sure you stop once you reach the end of the new array.
        If the leftmost numbers in the window are negative, keep removing them using a loop. */

        // int len = newArr.length;
        // int[] nums = new int[2*len];
        // int[] nums2 = new int[2*len];
        // for(int i=0;i<2*len;i++){
        //     nums2[i]=i;
        // }

        // for(int i = 0; i < len; i++) {
        //     nums[i] = newArr[i];
        //     nums[i + len] = newArr[i];
        // }

        // int left = 0;
        // int right = 0;
        // int sumOfWindow = nums[0];
        // int ans = nums[0];
        // while(true) {
        //     if((right - left + 1) == len) {
        //         sumOfWindow -= nums[left];
        //         left++;
        //         if(left <= right) {
        //             ans = Math.max(ans, sumOfWindow);
        //         }
        //     }
        //     if(sumOfWindow < 0) {
        //         sumOfWindow -= nums[left];
        //         left++;
        //     }
        //     else {
        //         right++;
        //         if(right == nums.length)
        //             break;
        //         sumOfWindow += nums[right];
        //         ans = Math.max(ans, sumOfWindow);
        //     }
        //     if(left > right) {
        //         right++;
        //         if(right == nums.length)
        //             break;
        //         sumOfWindow += nums[right];
        //         ans = Math.max(ans, sumOfWindow);
        //     }
        //     while(left < right && nums[left] < 0) {
        //         sumOfWindow -= nums[left];
        //         left++;
        //         ans = Math.max(ans, sumOfWindow);
        //     }
        // }
        // return ans; 

        //Solution 2
        int currSum = 0;
        int maxSum = nums[0];
        int totalSum = 0;
        int minSum = nums[0];
        int currSumForMin = 0;

        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            currSum = Math.max(nums[i], currSum + nums[i]);
            currSumForMin = Math.min(nums[i], currSumForMin + nums[i]);
            minSum = Math.min(currSumForMin, minSum);
            maxSum = Math.max(currSum, maxSum);
            System.out.println("Max " + maxSum + " ,Min " + minSum);
        }

        if(totalSum == minSum)
            return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}

// ans at [61, 242]
//[-5,-2,5,6,-2,-7,0,2,8,-5,-2,5,6,-2,-7,0,2,8]
// left = 5
// right =13
// sumOfWindow = 5
// ans =12
// len = 9
//1,2,3,4,1,2,3,4
//1,-1000,5,4
//[1,2,3,4]

//10, -2, 13, -2

/*
1
2
3
4
1,2
2,3
3,4
4,1
1,2,3
2,3,4
3,4,1
4,1,2
1,2,3,4
2,3,4,1
3,4,1,2
4,1,2,3
*/
