/* Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters. */

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         //Solution 1
//         //Using int[] array
//         List<Integer> list = new ArrayList<>();
        
//         int i = 0; 
//         int j = 0;
//         int k = p.length();
//         int count = 0;
        
//         int[] arr = new int[26];
        
//         for(char c : p.toCharArray()) {
//             if(arr[c - 'a'] == 0)
//                 count++;
//             arr[c - 'a']++;
//         }
        
        
//         while(j < s.length()) {
//             if(p.indexOf(s.charAt(j)) != -1) {
//                 arr[s.charAt(j) - 'a']--;
//                 if(arr[s.charAt(j) - 'a'] == 0)
//                     count--;
//             }
            
//             if(j - i + 1 < k)
//                 j++;

//             else if(j - i + 1 == k) {
//                 if(count == 0)
//                     list.add(i);
                
//                 if(p.indexOf(s.charAt(i)) != -1) {
//                     arr[s.charAt(i) - 'a']++;
//                     if(arr[s.charAt(i) - 'a'] == 1)
//                         count++;
//                 }
                
//                 i++;
//                 j++;
//             }
//         }
//         return list;
        
        //Solution 2
        //Using O(n) space and HashMap
//         List<Integer> list = new ArrayList<>();
        
//         int i = 0; 
//         int j = 0;
//         int k = p.length();
        
//         Map<Character, Integer> map = new HashMap<>();
        
//         for(char c : p.toCharArray())
//             map.put(c, map.getOrDefault(c, 0) + 1);
        
//         int count = map.size();
        
//         while(j < s.length()) {
//             if(map.containsKey(s.charAt(j))) {
//                 map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
//                 if(map.get(s.charAt(j)) == 0)
//                     count--;
//             }
            
//             if(j - i + 1 < k)
//                 j++;

//             else if(j - i + 1 == k) {
//                 if(count == 0)
//                     list.add(i);
                
//                 if(map.containsKey(s.charAt(i))) {
//                     map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//                     if(map.get(s.charAt(i)) == 1)
//                         count++;
//                 }
                
//                 i++;
//                 j++;
//             }
//         }
//         return list;
    }
}

//Solution 3
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        Map<Character, Integer> letterOccurencesInp = new HashMap<>();
        for(char ch : p.toCharArray()) {
            letterOccurencesInp.put(ch, letterOccurencesInp.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> currentMap = new HashMap<>();
        while(start <= end && end < s.length()) {
            char current = s.charAt(end);
            if(!letterOccurencesInp.containsKey(current)) {
                end++;
                start = end;
                currentMap.clear();
            }
            
            else if(currentMap.containsKey(current) && currentMap.get(current) >= letterOccurencesInp.get(current)) {
                while(s.charAt(start) != current) {
                    currentMap.put(s.charAt(start), currentMap.get(s.charAt(start)) - 1);
                    start++;
                }
                currentMap.put(s.charAt(start), currentMap.get(s.charAt(start)) - 1);
                start++;
            }

            else {
                currentMap.put(current, currentMap.getOrDefault(current, 0) + 1);
                end++;
            }
            if(end - start == p.length()) {
                answer.add(start);
            }
        }
        return answer;
    }
}
