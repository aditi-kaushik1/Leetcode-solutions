class Solution {
    public int missingNumber(int[] nums) {
        
        //Solution 1
        /* Given the array, find the length using the .length method.
           Then find the sum of numbers from 0 to length using n*(n + 1)/2 method.
           Now iterate over the loop and keep subtracting the arr[i] number.
           The number left in the end is the missing number. */
        // int n = nums.length;
        // int sum = (n*(n + 1))/2;
        // for(int i = 0; i < n; i++) { 
        //     sum -= nums[i];
        // }
        // return sum;
        
        //Solution 2
        /* Sort the numbers and see if all consecutive numbers are present or not.
        If they are all present, then return 0 or 'n', whichever is not present.
        This isn't a good solution though, because sorting will take O(nlogn)
        and will use more than O(1) space. */
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] != i)
        //         return i;
        // }
        // return nums.length;
        
        //Solution 3
        /* Check leetcode solution section for reference.
           Use hashset to store all numbers in the array
           Returrn the number if it is not present in HashSet. */
        // Set<Integer> h = new HashSet<>();
        // for(int num : nums) {
        //     h.add(num);
        // }
        // for(int i = 0; i <= nums.length; i++) {
        //     if(!h.contains(i))
        //         return i;
        // }
        // return -1;
        
        //Solution 4
        // Check out the leetcode solution section!
        /* Use bit manipulation wherever possible in such cases!!!!
        Find out the XOR of all the numbers in the array with all the numbers from 0 to n.
        The output will be the odd one out number.
        Return the output. */
//         int n = nums.length;
//         int res = 0;
//         for(int i = 0; i < nums.length; i ++) {
//             res = nums[i] ^ i ^ res;
//         }
//         res = res ^ nums.length;
//         return res;
        
        //Solution 5
        //Swapping numbers to their corresponding index cells
        //https://leetcode.com/problems/missing-number/discuss/70058/Swapping-numbers-to-the-same-index-cell
        //Check comment section of above link, for code
        int cur = 0;
        int pre = -1;
        int size = nums.length;
        while(cur < size) {
            if(nums[cur] != cur) {
                if(nums[cur] != size) {
                    int temp = nums[cur];
                    nums[cur] = nums[nums[cur]];
                    nums[temp] = temp;
                }
                else {
                    pre = cur;
                    cur++;
                }
                }
            else
                cur++;
        }
        return pre == -1 ? size : pre;
        /*This solution uses Swap sort. Learn it from Aditrya Verma's playlist.
        If pre remains -1, this means that n = nums.length is not present, 
        hence return size.
        The while loop is simple and is used to traverse through all elements
        to put them in their respective positions.
        While swapping, be carful, as we are dealing with indices.
        Keep cur constant untill all the swapping is done.
        If the corresponding element is already present at it's position, 
        then increment cur.
        According to this algorithm, it checks whether 'n' is present or not.
        If it is not present, then we need to return that.
        Else, n is taking the place of a number from 0 to (n-1).
        So, return that number. */
    }
}
