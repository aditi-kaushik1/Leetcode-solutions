/* Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        //Solution 1
        //Brute force approach
        //O(n^3) solution
//         int count = 0;
//         for(int begin = 0; begin < nums.length; begin++)
//             for(int end = begin + 1; end <= nums.length; end++) {
//                 int sum = 0;
//                 for(int i = begin; i < end; i++)
//                     sum += nums[i];
//                 if(sum == k)
//                     count++;
//             }
        
//         return count;
        
        //O(n^2) solution
        //O(n) space complexity
        //Using cumulative sum
//         int count = 0;
//         int n = nums.length;
//         int[] sum = new int[n + 1];
//         sum[0] = 0;
//         for(int i = 1; i <= n; i++)
//             sum[i] = sum[i - 1] + nums[i - 1];
        
//         for(int begin = 0; begin < n; begin++)
//             for(int end = begin + 1; end <= n; end++)
//                 if((sum[end] - sum[begin]) == k)
//                     count++;

//         return count;
        
        //O(n^2) solution
        //O(1) space
        //We don't really need the start and end indices.
//         int count = 0;
//         for(int i = 0; i < nums.length; i++) {
//             int sum = 0;
//             for(int j = i; j < nums.length; j++) {
//                 sum += nums[j];
//                 if(sum == k)
//                     count++;
//             }
//         }
        
//         return count;
        
        //Solution 4
        //Using HashMap
        //O(n) solution - both time and space
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
