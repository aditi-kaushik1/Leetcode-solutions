/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there? 

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109. */

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        //Solution 1
        //Time complexity : O(m + n)
        //Space complexity : O(m + n)
        //Height of the tree = Maximum recursive call stack size
        //Time limit exceeded
        // if(m == 0 || n == 0)
        //     return 0;
        // if(m == 1 && n == 1)
        //     return 1;
        // return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        
        //Solution 2
        //uniquePaths(m, n) = uniquePaths(n, m)
        String key = m + "," + n;
        if(map.containsKey(key))
            return map.get(key);
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 && n == 1)
            return 1;
        int x = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(key, x);
        map.put(n + "," + m, x);
        return x;
        
        //Solution 3
//         if(m == 0 || n == 0)
//             return 0;
//         if(m == 1 && n == 1)
//             return 1;
//         m--;
//         n--;
//         if(m < n) {
//             int temp = m;
//             m = n;
//             n = temp;
//         }
        
//         int j = 1;
//         long res = 1;
//         for(int i = m + 1; i <= (m + n); i++, j++) {
//             res *= i;
//             res /= j;
//         }
//         return (int)res;
    }
}
