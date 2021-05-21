/* Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 
Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */

class Solution {
    public int longestValidParentheses(String s) {
        //Solution 1
        //Brute force approach
        //O(n^3) time and O(1) space
        //Time limit exceeded
        //Break down the problem into 2 parts:
        /*Check if a given substring is a valid parenthesis or not.
        If it is a valiid parenthesis, then comapre it's length(j-i)
        with previous max. Check for all substrings of even length.
        j goes from i+2 to s.length(), since in substring(i,j),
        j gets excluded. j increments in steps of 2. */
        
//         int max = 0;
//         for(int i = 0; i < s.length(); i++)
//             for(int j = i + 2; j <= s.length(); j+= 2) {
//                 String sub = s.substring(i, j);
//                 if(isValid(sub))
//                     max = Math.max(max, j - i);
//             }
//         return max;
//     }
    
//     private boolean isValid(String s) {
//         int counter = 0;
//         for(char c : s.toCharArray()) {
//             if(c == '(')
//                 counter++;
//             else if(counter == 0 && c == ')')
//                 return false;
//             else
//                 counter--;
//         }
//         return counter == 0;
        
        //Solution 2
        //Use a stack
        //First push -1 in the stack
        //If you encounter '(' push it in the stack.
        //If you encounter ')', pop the last element.
        //If stack becomes empty, simply push the index i and 
        //go to the next iteration. 
        //Else, find i - stack.peek() and store in max if it is max.
        //Return max.
        //O(n) time and O(n) space
        // Stack<Integer> stack = new Stack<>();
        // stack.push(-1);
        // int max = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if(c == '(')
        //         stack.push(i);
        //     else {
        //         stack.pop();
        //         if(stack.isEmpty())
        //             stack.push(i);
        //         else {
        //             max = Math.max(max, i - stack.peek());
        //         }
        //     }
        // }
        // return max;
        
        //Brute force optimisation
        //Time - O(n^2), space - O(1)
        // int max = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     int count = 0;
        //     for(int j = i; j < s.length(); j++) {
        //         if(s.charAt(j) == '(')
        //             count++;
        //         else
        //             count--;
        //         if(count < 0)
        //             break;
        //         if(count == 0)
        //             max = Math.max(max, j - i + 1);
        //     }
        // }
        // return max;
        
        //Optimised solution
        //Time - O(n), Space - O(1)
        int left = 0;
        int right = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                left++;
            else if(c == ')')
                right++;
            
            if(left == right)
                max = Math.max(max, left + right);
            
            else if(right > left)
                left = right = 0;
        }
        left = 0;
        right = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ')')
                right++;
            else if(c == '(')
                left++;
            if(right == left)
                max = Math.max(max, left + right);
            else if(left > right)
                left = right = 0;
        }
        return max;
    }
}
