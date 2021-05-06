/* Write a function that reverses a string. The input string is given as an array of characters s.
  
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 
Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
  
Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. */

class Solution {
    public void reverseString(char[] s) {
        //Solution 1
        //Using stacks
        
        //Solution 2
        //USing a new array
        
        //Solution 3
        char temp;
        int n = s.length;
        for(int i = 0; i < n/2; i++) {
            temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }
}
