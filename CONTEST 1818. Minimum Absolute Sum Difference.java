/* You are given two positive integer arrays nums1 and nums2, both of length n.
The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
|x| is defined as:
x if x >= 0, or
-x if x < 0. */

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int currDiff = 0;
        int maxDiff = 0;
        int maxDiffIndex = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            currDiff = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff,currDiff);
            if(currDiff == maxDiff)
                maxDiffIndex = i;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = 0;
        
        for(int i = 0; i < n; i++) {
            currDiff = Math.abs(nums1[i] - nums2[maxDiffIndex]);
            minDiff = Math.min(currDiff,minDiff);
            if(currDiff == minDiff)
                minDiffIndex = i;
        }
        
        nums1[maxDiffIndex] = nums1[minDiffIndex];
        
        double minAbsSumDiff = 0D;
        for(int i = 0; i < n; i++) {
            minAbsSumDiff += Math.abs(nums1[i] - nums2[i]);
        }
        return (int)(minAbsSumDiff % (Math.pow(10,9) + 7));
    }
}
