class Solution {
    public int jump(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int helper(int[] nums, int index) {
        int answer = Integer. MAX_VALUE;
        if(map.containsKey(index))
            return map.get(index);
        if(index == 0)
            return 0;
        for(int i = index - 1; i >= 0; i--) {
            if(nums[i] >= index - i) {
                int x = helper(nums, i);
                answer = Math.min(x + 1, answer);
            }
        }
        map.put(index, answer);
        return answer;
    }
}
