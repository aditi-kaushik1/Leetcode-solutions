/*  Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true 

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. 
In this scenario, how would you change your code? */

class Solution {
    public boolean isSubsequence(String s, String t) {
//         int i = 0;
//         if(s.length() == 0)
//             return true;
//         for(int j = 0; j < t.length(); j++) {
//             if(t.charAt(j) == s.charAt(i))
//                 i++;
//             if(i == s.length())
//                 return true;
//         }
//         return false;
      
      //Solution 2
        /*Solution for follow up : 
        Use a HashSet to store all the subsequences,
        then for 10^9 strings, simply check if it is present in set or not. */
//         subsequences(t, "");
//         return set.contains(s);
//     }
    
//     HashSet<String> set = new HashSet<>();
    
//     public void subsequences(String ip, String op) {
//         if(ip.length() == 0) {
//             set.add(op);
//             return;
//         }
        
//         String op1 = op;
//         String op2 = op;
        
//         op2 = op2 + ip.charAt(0);
        
//         ip = ip.substring(1);
        
//         subsequences(ip, op1);
//         subsequences(ip, op2);
//         return;
        
        //Solution 3
        int index = -1;
        for(char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if(index == -1)
                return false;
        }
        return true;
    }
}
