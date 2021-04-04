/* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number. */

class Solution {
    public int findDuplicate(int[] nums) {
        //Swap sort doesn't seem suitable because not all elements occur once
        // and a lot of cases need to be dealt with.
        //Solution 1
        // HashSet<Integer> set = new HashSet<>();
        // for(int x : nums) {
        //     if(set.contains(x))
        //         return x;
        //     set.add(x);
        // }
        // return -1;
        
        //Solution 2
        // Arrays.sort(nums);
        // int n = nums.length;
        // for(int i = 0; i < n-1; i++) {
        //     if(nums[i] == nums[i+1])
        //         return nums[i];
        // }
        // return -1;
        
        //Solution 3
        /* Floyd's cycle finding algorithm
        Check leetcode solution page
        A sequence x,nums[x],nums[nums[x],nums[nums[nums[x]]]] is made.
        It enters a loop when the duplicate element is encountered.
        It is not necessary that the too meet at the point
        where the loop starts,when one is moving at twice the speed of other. */
        int tortoise = nums[0];
        int hare = nums[0]; 
        /*do while loop is used so that we can start both of them from nums[0].
        The two might meet after any number of times,
        so we use a do while loop instead of a for loop. 
        While loop is not used because tortoise == hare initially,
        so it won't enter the loop. */
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);
        
        tortoise = nums[0];
        //Loop to find the starting point.
        while(tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}
