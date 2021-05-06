/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case? */

class Solution {
    public boolean isAnagram(String s, String t) {
        //Solution 1
        //Inefficient - O(nlogn) solution
//         char[] s1 = s.toCharArray();
//         char[] t1 = t.toCharArray();
        
//         Arrays.sort(s1);
//         Arrays.sort(t1);
        
//         return Arrays.equals(s1,t1);
        
        //Solution 2
        int[] s1 = new int[26];
        
        for(char c : s.toCharArray())
            s1[c - 'a']++;
        
        for(char c : t.toCharArray()) {
            if(s1[c - 'a'] == 0)
                return false;
            s1[c - 'a']--;
        }
        
        for(int i = 0; i < 26; i++)
            if(s1[i] != 0)
                return false;
        
        return true;
    }
}
