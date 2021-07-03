/* Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome. 

Constraints:
-231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?*/

class Solution {
    public boolean isPalindrome(int x) {
        //Solution 1
        // StringBuilder obj = new StringBuilder();
        // String reversed = obj.append(String.valueOf(x)).reverse().toString();
        // return String.valueOf(x).equals(reversed);
        
        //Solution 2
        // if(x < 0)
        //     return false;
        // int y = x;
        // int reversed = 0;
        // while(y != 0) {
        //     int pop = y % 10;
        //     y /= 10;
        //     reversed = reversed * 10 + pop;
        // }
        // try {
        //     return x == reversed;
        // }
        // catch(NumberFormatException e) {
        //     return false;
        // }
        
        //Solution 3
        //Leetcode solution page
        //O(log(n)) [to the base 10]
        //Space complexity is O(1)
        if(x == 0)
            return true;
        if(x < 0 || x % 10 == 0)
            return false;
        int reversed = 0;
        while(x > reversed) {
            reversed = (10 * reversed) + (x % 10);
            x /= 10;
        }
        return x == reversed || x == reversed/10;
    }
}
