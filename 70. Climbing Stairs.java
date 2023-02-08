/* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45 */

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        //Answer is Fibonacci series!!!!!!
        //Solution 1
        //Top down approach
        // if(map.containsKey(n))
        //     return map.get(n);
        // if(n == 1) {
        //     map.put(1,1);
        //     return 1;
        // }
        // else if(n == 2) {
        //     map.put(2,2);
        //     return 2;
        // }
        // else {
        //     int ans = climbStairs(n - 1) + climbStairs(n - 2);
        //     map.put(n, ans);
        //     return ans;
        // }

        //Solution 2
        //Bottom up approach
        // int[] arr = new int[n + 1];
        // arr[1] = 1;
        // if(n == 1)
        //     return 1;
        // arr[2] = 2;
        // for(int i = 3; i <= n; i++) {
        //     arr[i] = arr[i - 1] + arr[i - 2];
        // }
        // return arr[n];

        //Solution 3
        //Space optimisation
        int prev = 1;
        int prev2 = 2;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int curr = 1;
        for(int i = 3; i <= n; i++) {
            curr = prev + prev2;
            prev = prev2;
            prev2 = curr;
        }
        return curr;
    }
}

// 1 -> 1 (1)
// 2 -> 1+1, 2 (2)
// 3 -> 1+1+1, 1+2, 2+1 (3)
// 4 -> 1+1+1+1, 1+2+1, 2+2, 2+1+1, 1+1+2 (5)
// 5 -> 1+1+1+1+1, 1+2+1+1,......
// The answer for any case can be obtained by adding 1 to every case in previous number and adding 2 to every case in previous number.
