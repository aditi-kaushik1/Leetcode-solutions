class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long answer = 0;
        String str = "";
        int length = nums.length;
        for(int i = 0; i < length/2; i++) {
            String str1 = String.valueOf(nums[i]);
            String str2 = String.valueOf(nums[length - i - 1]);
            str = str1 + str2;
            System.out.println(str);
            Long add = Long.parseLong(str);
            answer += add;
        }
        System.out.println(length);
        if(length % 2 == 1) {
            answer += nums[length/2];
        }
        return answer;
    }
}
