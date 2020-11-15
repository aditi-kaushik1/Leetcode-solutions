/*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.*/

class Solution {
    public int[] runningSum(int[] nums) {
        /*Solution 1*/
        /*Not a good approach, O(n^2) is the time complexity as nested loop is present.*/
     // int n=nums.length;
     // int[] runningSum=new int[n];
     // for(int i=0;i<n;i++) {
     // for(int j=0;j<=i;j++) {
     // runningSum[i]+=nums[j];
     // }
     // }
     // return runningSum;   
        
     /*Solution 2*/
     /*Made changes in the existing array to reduce space complexity*/
        // for(int i=1;i<nums.length;i++){
        //     nums[i]+=nums[i-1];
        // }
        // return nums;
        
        /*Solution 3*/
        /*Same as solution 2, but used a new array for it*/
        int[] b=new int[nums.length];
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            b[i]=prev+nums[i];
            prev=b[i];
        }
        b[0]=nums[0];
         return b;
    }
}
