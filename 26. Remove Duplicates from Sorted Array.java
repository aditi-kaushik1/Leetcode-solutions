/* Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory. */

class Solution {
    public int removeDuplicates(int[] nums) {
        //Check leetcode solution page
        /* Use 2 pointers. Initialise i = 0.
        Run a loop using j as the loop variable,
        run it from 1 to j < nums.length.
        If nums[i] == nums[j], simply keep incrementing j.
        Else, increment i and put nims[i] = nums[j].
        In the end of the array, those extra elements will be present.
        So, just return the first (i + 1) elements, which are unique.
        When we first encounter a unique element, after the 0th element,
        then i becomes 1 (although 2 unique elements have been 
        encountered till then. Hence we use i+1 in the return statement.
        It doesn't matter what values are set beyond the returned length.*/
        if(nums.length == 0)
            return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
        //i + 1 is the length of the unique elements.
        //Here int is returned because only the numbers upto that 
        //integer are returned.  
        //It doesn't matter if the elements after that are still present.
    }
}
