/* Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", s = "dog dog dog dog"
Output: false
 
Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space. */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        //Solution 1
        //Using HashMap
        //containsValue() has time complexity O(n)
        //Time complexity of solution 1 and 2 is same
        
//         HashMap<Character, String> map = new HashMap<>();
//         String[]  strArr = s.split(" ");
        
//         if(pattern.length() != strArr.length)
//             return false;
        
//         for(int i = 0; i < pattern.length(); i++) {
//             char ch = pattern.charAt(i);
            
//             if(map.containsKey(ch)) {
//                 if(!map.get(ch).equals(strArr[i]))
//                     return false;
//             }
            
//             else {
//                 if(map.containsValue(strArr[i]))
//                     return false;
//                 map.put(ch, strArr[i]);
//             }
//         }
//         return true;
        
        //Solution 2
        //Using another helper method to check if the map contains the same value or not
        
//         HashMap<Character, String> map = new HashMap<>();
//         String[]  strArr = s.split(" ");
//         if(pattern.length() != strArr.length)
//             return false;
//         int i = 0;
//         for(char ch : pattern.toCharArray()) {
//           if(mapContains(map, strArr[i]) != '$' && mapContains(map, strArr[i]) != ch)
//                 return false;
//             if(map.containsKey(ch) && !map.get(ch).equals(strArr[i]))
//                 return false;
//             map.put(ch, strArr[i++]);
//         }
//         return true;
//     }
    
//     public char mapContains(HashMap<Character, String> map, String s) {
//         for(char ch : map.keySet())
//             if(map.get(ch).equals(s))
//                 return ch;
//         return '$';
     
     //Solution 3
     
     Map<Character, String> oneToOne = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        if(pattern.length() != s.split(" ").length)
            return false;
        int index = 0;
        for(String word : s.split(" ")) {
            char current = pattern.charAt(index++);
            if(oneToOne.containsKey(current) && !oneToOne.get(current).equals(word))
                return false;
            if(reverseMap.containsKey(word) && reverseMap.get(word) != current)
                return false;
            reverseMap.put(word, current);
            oneToOne.put(current, word); 
        }
        return true;
    }
}
