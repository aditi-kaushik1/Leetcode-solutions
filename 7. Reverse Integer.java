/* Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321 

Constraints:
-231 <= x <= 231 - 1*/

class Solution {
    public int reverse(int x) {
        // int y = x;
        // String res = "";
        // while(x != 0) {
        //     res += Math.abs(x % 10);
        //     x /= 10;
        // }
        // try {
        //     return (y < 0) ? Integer.parseInt(res) * -1 : Integer.parseInt(res);
        // } catch(NumberFormatException e) {
        //     return 0;
        // }
        
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))
               return 0;
            if(x > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))
               return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }
}
