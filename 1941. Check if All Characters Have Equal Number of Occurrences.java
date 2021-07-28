/* Given a string s, return true if s is a good string, or false otherwise.
A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency). */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray())
            arr[ch - 'a']++;
        
        int numberOfOccurence = arr[s.charAt(0) - 'a'];
        
        for(int i = 0; i < 25; i++) {
            if(arr[i] != 0 && arr[i] != numberOfOccurence)
                return false;
        }
        
        return true;
    }
}
