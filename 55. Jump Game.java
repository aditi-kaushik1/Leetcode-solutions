class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    Map<Integer, Boolean> map = new HashMap<>();
    public boolean helper(int[] nums, int index) {
        if(map.containsKey(index))
            return map.get(index);
        if(index == 0)
            return true;
        for(int i = index - 1; i >= 0; i--) {
            if((nums[i] >= index - i) && (helper(nums, i) == true)) {
                map.put(index, true);
                return true;
            }
        }
        map.put(index, false);
        return false;
    }  
}
