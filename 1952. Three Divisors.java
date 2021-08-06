/* Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
An integer m is a divisor of n if there exists an integer k such that n = k * m.

Example 1:

Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.
Example 2:

Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.

Constraints:
1 <= n <= 104 */

class Solution {
    public boolean isThree(int n) {
        if(n == 1 || !isPerfectSquare(n))
            return false;
        return rootIsPrime(n);
    }
    
    public boolean isPerfectSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt*sqrt == n;
    }
    
    public boolean rootIsPrime(int n) {
        int sqrt = (int)Math.pow(n, 0.5);
        for(int i = 2; i <= Math.pow(sqrt, 0.5); i++) {
            if(sqrt % i == 0)
                return false;
        }
        return true;
    }
}
