/* Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area. */

class Solution {
    //Solution
    /* Apply MAH on each row and find the max area.
    Then calculate the max out of all these rows.
    Write a for loop for the first row and apply MAH.
    Then run a nested for loop with an if else condition,
    checking if the entry, arr[i][j] == 0, then put nums[j] = 0.
    Else, put nums[j] = arr[i][j] + nums[j].
    Apply MAH on this and calculate the max.
    Then finally return the maximum value. */
    public int maximalRectangle(char[][] matrix1) {
        
        int m = matrix1.length;
        if(m == 0)
            return 0;
        int n = matrix1[0].length;
        int[] nums = new int[n];
        
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(matrix1[i][j]));
            }
        }
        
        int max = 0;
        
        for(int j = 0; j < n; j++) {
            nums[j] = matrix[0][j];
        }
        max = MAH(nums,n);
        
        for(int i = 1; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    nums[j] = 0;
                else
                    nums[j] = nums[j] + matrix[i][j];
            }
            max = Math.max(max, MAH(nums,n));
        }
        
        return max;
    }
    
    public int MAH(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ansLeft = new int[n];
        int[] ansRight = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                ansLeft[i] = i;
            else
                ansLeft[i] = i - stack.peek() - 1;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if(stack.isEmpty())
                ansRight[i] = n - i - 1;
            else
                ansRight[i] = stack.peek() - i - 1;
            stack.push(i);
        }
        
        int[] area = new int[n];
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            area[i] = nums[i] * (1 + ansLeft[i] + ansRight[i]);
            maxArea = Math.max(area[i],maxArea);
        }
        return maxArea;
    }     
}
