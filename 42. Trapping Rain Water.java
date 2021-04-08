/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. */

class Solution {
    /* Solution
    We break down this problem into sub parts.
    Find the sum of the water collected on top of each building
    This sum will give the answer.
    Water on top of building = height of water - height of building
    Height of water = minimum of maxL[i] and maxR[i].
    So first step is to find 2 arrays starting loop from either sides,
    to find the max value in left and right subarrays.
    */
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int[] water = new int[n];
        int ans = 0;
        
        maxL[0] = height[0];
        for(int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }
        
        maxR[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            maxR[i] = Math.max(height[i],maxR[i+1]);
        }
        
        for(int i = 0; i < n; i++) {
            water[i] = Math.min(maxL[i],maxR[i]) - height[i];
            ans += water[i];
        }
        return ans;
    }
}
