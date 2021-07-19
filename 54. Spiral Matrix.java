/* Given an m x n matrix, return all elements of the matrix in spiral order. */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //Columns
        int left = 0;
        int right = matrix[0].length - 1;
        
        //Rows
        int top = 0;
        int bottom = matrix.length - 1;
        int dir = 0;
        
        while(left <= right && top <= bottom) {
            //Left to right
            if(dir == 0) {
                for(int x = left; x <= right; x++)
                    list.add(matrix[top][x]);
                top++;
            }
            
            //Top to bottom
            else if(dir == 1) {
                for(int x = top; x <= bottom; x++)
                    list.add(matrix[x][right]);
                right--;
            }
            
            //Right to left
            else if(dir == 2) {
                for(int i = right; i >= left; i--)
                    list.add(matrix[bottom][i]);
                bottom--;
            }
            
            //Bottom to top
            else if(dir == 3) {
                for(int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);
                left++;
            }
            
            //Remember to add 1 to change the direction
            dir = (dir + 1) % 4;
        }
        return list;
    }
}
