/* You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 

Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:

Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:

Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
 

Constraints:

1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters. */

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int numberOfDifferences = 0;
        int[] charsInS = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            if(numberOfDifferences > 2) return false;
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2)  numberOfDifferences++;
            charsInS[ch1 - 'a']++;
            charsInS[ch2 - 'a']--;
        }
        for(int x : charsInS) {
            if(x != 0)
                return false;
        }
        return (numberOfDifferences <= 2) ? true : false;
    }
}
