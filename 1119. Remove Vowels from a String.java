/* Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

Example 1:

Input: s = "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
Example 2:

Input: s = "aeiou"
Output: ""

Constraints:
1 <= s.length <= 1000
s consists of only lowercase English letters. */

class Solution {
    public String removeVowels(String s) {
        String ans = "";
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        for(char c : s.toCharArray())
            if(!vowel.contains(c))
                ans += c;
        return ans;
    }
}
