/* Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 
Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters. */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Solution 1
        //Using HashMap
//         int r = ransomNote.length();
//         int m = magazine.length();
        
//         if(r > m)
//             return false;
//         Map<Character, Integer> map = new HashMap<>();
//         for(char ch : magazine.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
        
//         for(char ch : ransomNote.toCharArray()) {
//             if(!map.containsKey(ch))
//                 return false;
//             map.put(ch, map.get(ch) - 1);
//             if(map.get(ch) == 0)
//                 map.remove(ch);
//         }
//         return true;
        
        //Solution 2
        //Using int array of size 26
        
        int r = ransomNote.length();
        int m = magazine.length();
        
        int[] arr = new int[26];
        
        for(char ch : magazine.toCharArray()) {
            arr[ch - 'a']++;
        }
        
        for(char ch : ransomNote.toCharArray()) {
            if(arr[ch - 'a'] == 0)
                return false;
            arr[ch - 'a']--;
        }
        return true;
    }
}
