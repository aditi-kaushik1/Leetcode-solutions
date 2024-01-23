/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters. 
*/

class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        String[][] dp = new String[s1.length()][s2.length()];

        String longestCommonSubsequence = helper(s1, s2, 0, 0, dp);

        int i = 0;
        int j = 0;
        int k = 0;
        StringBuilder ans = new StringBuilder();

        while(i != s1.length() && j != s2.length() && k != longestCommonSubsequence.length()) {
            if(s1.charAt(i) == longestCommonSubsequence.charAt(k) && s2.charAt(j) == longestCommonSubsequence.charAt(k)) {
                ans.append(s1.charAt(i));
                i++;
                j++;
                k++;
            }

            else if(s1.charAt(i) == longestCommonSubsequence.charAt(k)) {
                while(s2.charAt(j) != longestCommonSubsequence.charAt(k)) {
                    ans.append(s2.charAt(j));
                    j++;
                }
            }

            else if(s2.charAt(j) == longestCommonSubsequence.charAt(k)) {
                while(s1.charAt(i) != longestCommonSubsequence.charAt(k)) {
                    ans.append(s1.charAt(i));
                    i++;
                }
            }

            else {
                while(s1.charAt(i) != longestCommonSubsequence.charAt(k)) {
                    ans.append(s1.charAt(i));
                    i++;
                }

                while(s2.charAt(j) != longestCommonSubsequence.charAt(k)) {
                    ans.append(s2.charAt(j));
                    j++;
                }
            }
        }

        while(i != s1.length()) {
            ans.append(s1.charAt(i));
            i++;
        }

        while(j != s2.length()) {
            ans.append(s2.charAt(j));
            j++;
        }

        return ans.toString();
    }

    private String helper(String s1, String s2, int i, int j, String[][] dp) {
        if(i == s1.length() || j == s2.length())
            return "";
        if(dp[i][j] != null)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            dp[i][j] = s1.charAt(i) + helper(s1, s2, i + 1, j + 1, dp);
        else {
            int l1 = helper(s1, s2, i + 1, j, dp).length();
            int l2 = helper(s1, s2, i, j + 1, dp).length();
            if(l1 >= l2)
                dp[i][j] = helper(s1, s2, i + 1, j, dp);
            else
                dp[i][j] = helper(s1, s2, i, j + 1, dp);
        }
        return dp[i][j];
    }
}
