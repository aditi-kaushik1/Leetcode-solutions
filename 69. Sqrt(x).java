/* Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5. 
Constraints:
0 <= x <= 231 - 1*/

class Solution {
    public int mySqrt(int x) {
        //Solution 1
        /* Time limit exceeded
        Linear search is slow for large numbers */
        
        // int i = 0;
        // while(i*i < x)
        //     i++;
        // if(i*i == x)
        //     return i;
        // return i - 1;
        
        //Solution 2
        //Use binary search
        int left = 0;
        int right = x;
        int mid = 0;
        
        //Edge cases to deal with "division by 0"
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        
        while(left <= right) {
            mid = left + (right - left)/2;
            if(mid == x/mid)
                return mid;
            else if(mid < x/mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
