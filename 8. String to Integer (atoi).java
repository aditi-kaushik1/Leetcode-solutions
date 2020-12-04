/*Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
Note:
Only the space character ' ' is considered a whitespace character.
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
If the numerical value is out of the range of representable values, 231 − 1 or −231 is returned.*/


class Solution {
    public int myAtoi(String s) {
        //Loop variable
        int i = 0;
        //Decides whether no. is positive or negative
        int sign = 1;
        //Stores the output
        int result = 0;
        if (s.length() == 0) 
            return 0;
        //Discard whitespaces in the beginning
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        // Build the result and check for overflow/underflow condition
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10))
            {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}
