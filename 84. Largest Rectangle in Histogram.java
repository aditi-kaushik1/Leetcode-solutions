/* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram. */

class Solution {
    public int largestRectangleArea(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
//         int n = heights.length;
//         int[] ansLeft = new int[n];
        
//         for(int i = 0; i < n; i++) {
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
//                 stack.pop();
//             if(stack.isEmpty())
//                 ansLeft[i] = i;
//             else
//                 ansLeft[i] = i - stack.peek() - 1;
//             stack.push(i);
//         }
        
//         stack.clear();
//         int[] ansRight = new int[n];
        
//         for(int i = n - 1; i >= 0; i--) {
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
//                 stack.pop();
//             if(stack.isEmpty())
//                 ansRight[i] = n - i - 1;
//             else
//                 ansRight[i] = stack.peek() - i - 1;
//             stack.push(i);
//         }
        
//         int[] sum = new int[n];
        
//         int finalAns = Integer.MIN_VALUE;
        
//         for(int i = 0; i < n; i++) {
//             sum[i] = heights[i] * (ansLeft[i] + ansRight[i] + 1);
//             finalAns = Math.max(sum[i],finalAns);
//         }
//         return finalAns
        
        //Solution 2: slightly different thinking used in calculations
        int n = heights.length;
        int[] ansLeft = new int[n];
        int[] ansRight = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty())
                ansLeft[i] = -1;
            else
                ansLeft[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty())
                ansRight[i] = n;
            else
                ansRight[i] = stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        int[] area = new int[n];
        for(int i = 0; i < n; i++) {
            area[i] = heights[i]*(ansRight[i] - ansLeft[i] - 1);
            maxArea = Math.max(maxArea,area[i]);
        }
        return maxArea;
    }
}
