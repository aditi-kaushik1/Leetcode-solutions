/* Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf(). 

Constraints:
0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters. */

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int m = haystack.length();
        int n = needle.length();
        
        if(n == 0)
            return 0;
        
        while(i < m) {
            int j = 0;
            int ans = i;
            
            while(j < n && i < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
            if(j == n)
                return ans;
            else if(i == m)
                return -1;
            else {
                i = ans + 1;
            }
        }
        return -1;
    }
}
