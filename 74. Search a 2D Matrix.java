/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row. */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
if((m == 0 && n == 0) || target < matrix[0][0] || target > matrix[m - 1][n - 1])
    return false;
    
        int mid = 0;
        int left = 0;
        int right = m - 1;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(matrix[mid][0] == target)
                return true;
            else if(matrix[mid][0] > target)
                right = mid - 1;
            else {
                if(target <= matrix[mid][n - 1])
                    break;
                else left = mid + 1;
            }
        }
        
        left = 0;
        right = n - 1;
        
        while(left <= right) {
            int midCol = left + (right - left)/2;
            if(matrix[mid][midCol] == target)
                return true;
            else if(matrix[mid][midCol] < target)
                left = midCol + 1;
            else
                right = midCol - 1;
        }
        return false;
    }
}
