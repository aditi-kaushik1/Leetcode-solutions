/* Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1. */

class Solution {
    public int firstUniqChar(String s) {
        //Solution 1
        //O(N^2) complexity
        //Brute force
        // for(int i = 0; i < s.length(); i++) {
        //     boolean isRepeated = false;
        //     for(int j = 0; j < s.length(); j++) {
        //         if(s.charAt(i) == s.charAt(j) && i != j) {
        //             isRepeated = true;
        //             break;
        //         }
        //     }
        //     if(isRepeated == false)
        //         return i;
        // }
        // return -1;
        
        //Solution 2
        //O(N) complexity
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
               return i;
        }
               return -1;
    }
}
