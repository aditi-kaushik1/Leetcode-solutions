class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int ans = 0;
        // for(int x : nums) {
        //     ans = ans ^ x;
        // }
        // return ans;

        int left = 0;
        int right = nums.length;
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(mid == 0 || mid == nums.left - 1)
                return mid;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if(nums[mid] == nums[mid - 1])
        }
    }
}
