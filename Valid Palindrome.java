/*Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 
Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters. */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+","").toLowerCase();
        System.out.println(s);
        char[] strArr = s.toCharArray();
        int n = strArr.length;
        for(int i = 0; i < n/2; i++) {
            if(strArr[i] != strArr[n - i -1])
                return false;
        }
        return true;
    }
}
