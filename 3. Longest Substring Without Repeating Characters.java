/* Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 
Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Solution 1
        //Sliding window approach
//         int i = 0;
//         int j = 0;
//         int n = s.length();
//         int ans = 1;
//         if(n == 0)
//             return 0;
        
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         while(j < n) {
//            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
//             if(map.get(s.charAt(j)) == 1)
//                 ans = Math.max(ans, j - i + 1);
            
//             else if(map.get(s.charAt(j)) == 2) {
//                 while(map.get(s.charAt(j)) > 1) {
//                     if(s.charAt(i) == s.charAt(j)) {
//                         map.put(s.charAt(i), 1);
//                         i++;
//                         break;
//                     }
//                     else if(map.get(s.charAt(i)) == 1)
//                         map.remove(s.charAt(i));
//                     else
//                         map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//                     i++;
//                 }
//             }
//             j++;
//         }
//         return ans;
        
        //Solution 2
        //Sliding window approach
//         int i = 0;
//         int j = 0;
//         int n = s.length();
//         if(n == 0)
//             return 0;
//         int ans = 1;
//         HashMap<Character, Integer> map = new HashMap<>();
//         while(j < n) {
//             map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);
            
//             if(map.size() == j - i + 1) {
//                 ans = Math.max(ans, j - i + 1);
//             }
            
//             else if(map.size() < j - i + 1) {
//                 while(map.size() < j - i + 1) {
//                     if(map.get(s.charAt(i)) == 1)
//                         map.remove(s.charAt(i));
//                     else
//                         map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    
//                     i++;
//                 }
//             }
//             j++;
//         }
//         return ans;
        
        //Solution 3
        //Brute force approach
        //O(n^3) solution
        //Do not use
//         int n = s.length();
//         if(n == 0)
//             return 0;
//         int res = 1;
        
//         for(int i = 0; i < n - 1; i++) {
//             for(int j = 1; j < n; j++) {
//                 if(isUnique(s,i,j) == true)
//                     res = Math.max(res, j - i + 1);
//             }
//         }
//         return res;
//     }
    
//     private boolean isUnique(String s, int begin, int end) {
//         int[] arr = new int[128];
//         for(int i = begin; i <= end; i++) {
//             char c = s.charAt(i);
//             arr[c]++;
//             if(arr[c] > 1)
//                 return false;
//         }
//         return true;
//     }
        
        //Solution 4
        //Sliding window approach, but using an int array instead of HashMap
//         int i = 0;
//         int j = 0;
//         int n = s.length();
//         int[] arr = new int[128];
//         if(n == 0)
//             return 0;
//         int res = 1;
//         while(j < n) {
//             char c = s.charAt(j);
//             arr[c]++;
            
//             while(arr[c] > 1) {
//                 char x = s.charAt(i);
//                 arr[x]--;
//                 i++;
//             }
//             res = Math.max(res, j - i + 1);
            
//             j++;
//         }
//         return res;
//    }
        
        //Solution 5
        //Optimised Sliding Window Solution
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c))
                i = Math.max(i, map.get(c));
            res = Math.max(res, j - i + 1);
            
            map.put(c, j + 1);
        }
        return res;
    }
}
