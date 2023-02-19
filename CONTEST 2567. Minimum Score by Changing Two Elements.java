class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.min(nums[len - 1] - nums[2], Math.min(nums[len - 2] - nums[1], nums[len - 3] - nums[0]));
    }
}
