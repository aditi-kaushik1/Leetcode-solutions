/* Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 
Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters. */

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        for(int i = 0 ; i < s.length(); i++) 
            if(map.get(s.charAt(i)) == 1)
                return i;
        
        return -1;
    }
}
