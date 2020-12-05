/* Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering. */


class Solution {
    public int minSteps(String s, String t) {
        /* The basic idea is to use hashing and check how many 
        characters of t are different from s. */
        // Map<Character,Integer> map = new HashMap<>();
        // for(char e : s.toCharArray()){
        //     if(map.containsKey(e))
        //         map.put(e,map.get(e) + 1);
        //     else
        //         map.put(e , 1);
        // }
        // int count = 0;
        // for(int i = 0; i < t.length(); i ++) {
        //     char c = t.charAt(i);
        //     if(map.containsKey(c) &&  map.get(c) > 0){
        //         map.put(c,map.get(c) - 1);
        //         continue;
        //     }
        //     count ++;
        // }
        // return count;
        
        /*Solution 2*/
        //Maintaining the count of characters in array
        //Stores the number of times each character occurs
        int[] arr = new int[26];
        //Stores the output
        int ans = 0;
        //Stores the string length to use in for loop
        int n = s.length();
        for(int i = 0; i < n; i ++) {
            //Increment the count of each character of s.
            arr[s.charAt(i) - 'a']++;
            //Decrement the count of each character in t.
            arr[t.charAt(i) - 'a']--;
        }
        //Check for all 26 characters
        for(int i = 0; i < 26; i ++){
            //Check for individual elements
            if(arr[i] > 0)
                ans += arr[i];
        }
        return ans;
    }
}
