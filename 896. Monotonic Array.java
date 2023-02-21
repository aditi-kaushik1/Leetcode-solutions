class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1)
            return true;
        boolean isIncreasing = false;
        int j = 1;
        if(nums[0] < nums[1])
            isIncreasing = true;
        else if(nums[0] > nums[1])
            isIncreasing = false;
        else {
            while(j < nums.length && nums[0] == nums[j]) {
                j++;
            }
            if(j == nums.length)
                return true;
            if(nums[0] < nums[j])
                isIncreasing = true;
        }
        for(int i = 1; i < nums.length - 1; i++) {
            if(isIncreasing == true && nums[i] > nums[i + 1])
                return false;
            else if(isIncreasing == false && nums[i] < nums[i + 1])
                return false;
        }
        return true;
    }
}
