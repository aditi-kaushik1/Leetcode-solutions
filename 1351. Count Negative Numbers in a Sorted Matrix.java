/* Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100 
Follow up: Could you find an O(n + m) solution? */

class Solution {
    public int countNegatives(int[][] grid) {
        //Solution 1
        //Brute force
        //O(n^2) solution
        // int num = 0;
        // int rows = grid.length;
        // int cols = grid[0].length;
        // for(int i = 0; i < rows; i++)
        //     for(int j = 0; j < cols; j++)
        //         if(grid[i][j] < 0)
        //             num++;
        // return num;
        
        //Solution 2
        //O(rows * log(cols))
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        int l = 0;
        int r = cols - 1;
        int mid = 0;
        int lastNeg = cols - 1;
        
        for(int row = 0; row < rows; row++) {
            if(grid[row][0] < 0) {
                res += cols;
                continue;
            }
            else if(grid[row][cols - 1] > 0)
                continue;
            
            else {
                l = 0;
                r = lastNeg;
                while(l <= r) {
                    mid = l + (r - l)/2;
                    if(grid[row][mid] < 0)
                        r = mid - 1;
                    else
                        l = mid + 1;
                }
            }
            res += cols - l;
            lastNeg = l;
        }
        return res;
    }
}
