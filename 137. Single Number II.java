/*Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

class Solution {
    public int singleNumber(int[] nums) {
        /*Solution 1*/
        /*Universal method which can be used for all similar questions 
        having an odd one out element.*/
        //Check for all 32 bits.
        //Use shift to check if current bit is set.
        //strategy: Bit Manipulation
        int answer = 0;
        //count how many 1's are at the ith bit
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                //see if there is a 1 at the ith bit in number n
                count += (n >> i) & 1;
            }
            //if there is not a mutiple of 3 that means this bit is part of the answer
            //add to answer by using OR and right shifting i positions
            answer |= (count % 3) << i;
        }
        return answer;
 
        
        /*Solution 2*/
        /*Time complexity : O(n)
          Space Complexity : O(n);
         /*Use HashMap to store the element and it's count. 
         Check if the count is 1, then return that element.*/
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++)
        //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // for(Map.Entry<Integer,Integer> e: map.entrySet()){
        //     if(e.getValue().equals(1)){
        //         return e.getKey();
        //     }
        // }
        // return -1;
        
        
        /* Solution 3 */
        /* Sorting + Linear Traversal */
        /* Optimised version of HashMap solution */
        /* Video Link : 
        youtube.com/watch?v=cOFAmaMBVps */
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length-4;i+=3){
        //     if(!(nums[i]==nums[i-1])){
        //         return nums[i-1];
        //     }
        // }
        // if(nums.length>=2 && nums[0]!=nums[1])
        //     return nums[0];
        // if(nums.length>=2 && nums[nums.length-2]!=nums[nums.length-1])
        //     return nums[nums.length-1];
        // if(nums.length==1)
        //     return nums[0];
        // return -1;
    }
}
