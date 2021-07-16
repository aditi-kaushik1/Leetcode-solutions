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
        
		//For edge condition, when both haystack and needle are empty strings
        if(n == 0)
            return 0;
        
		//Nested while loop is used to match the corresponding characters of both strings
        while(i < m) {
            int j = 0;
			
			//Store the value of i, so that it is not lost
            int ans = i;
            
            while(j < n && i < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
			//Case where the needle is found in haystack
            if(j == n)
                return ans;
				
			//Case where we reach the end of haystack, but the needle is not present
            else if(i == m)
                return -1;
				
			//Case where the end is not reached, make sure you change the value of i back to ans + 1
            else {
                i = ans + 1;
            }
        }
		
		//Case where the first characters of needle wasn't present in haystack 
		//and we reached the end of the outer loop
        return -1;
    }
}
