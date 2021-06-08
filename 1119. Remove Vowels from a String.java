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
    public int calculateTime(String keyboard, String word) {
        // int position = 0;
        // int sum = 0;
        // char[] keys = keyboard.toCharArray();
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < keys.length; i++)
        //     map.put(keys[i], i);
        // for(char c : word.toCharArray()) {
        //     int diff = Math.abs(map.get(c) - position);
        //     position = map.get(c);
        //     sum += diff;
        // }
        // return sum;
        
        int[] arr = new int[26];
        for(int i = 0; i < keyboard.length(); i++)
            arr[keyboard.charAt(i) - 'a'] = i;
        int position = 0;
        int sum = 0;
        for(char c : word.toCharArray()) {
            sum += Math.abs(position - arr[c - 'a']);
            position = arr[c - 'a'];
        }
        return sum;
    }
}
