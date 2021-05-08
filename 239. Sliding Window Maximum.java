/* You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. 
Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
 Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int begin = 0;
        int end = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> list = new LinkedList<>();
        
        while(end < n) {
            while(!list.isEmpty() && list.peekLast() < nums[end])
                list.pollLast();
                
            list.addLast(nums[end]);
            
            if(end - begin + 1 < k)
                end++;
            
            else {
                ans[begin] = list.peek();
                
                if(list.getFirst() == nums[begin])
                    list.removeFirst();
                
                begin++;
                end++;
            }
        }
        return ans;
    }
}
