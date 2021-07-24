/* Given an integer n, return the number of trailing zeroes in n!.
Follow up: Could you write a solution that works in logarithmic time complexity? 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:
0 <= n <= 104*/

class Solution {
    public int trailingZeroes(int n) {
        //Solution 1
        // int count = 0;
        // while(n/5 != 0) {
        //     count += n/5;;
        //     n /= 5;
        // }
        // return count;
        
        //Solution 2
        int i = 1;
        int count = 0;
        while(n/Math.pow(5,i) != 0) {
            count += n/Math.pow(5,i++);
        }
        return count;
    }
}
