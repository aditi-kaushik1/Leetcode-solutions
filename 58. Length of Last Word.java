/* Given a string s consists of some words separated by spaces, return the length of the last word in the string. 
If the last word does not exist, return 0.
A word is a maximal substring consisting of non-space characters only. */

class Solution {
    public int lengthOfLastWord(String s) {
        //Solution 1
        // if(s == null || s == "")
        //     return 0;
        // String[] arr = s.split(" ");
        // if(arr.length == 0)
        //     return 0;
        // return arr[arr.length - 1].length();
        
        //Solution 2
        // if(s == null || s == "" || s.trim().length() == 0)
        //     return 0;
        // StringBuilder str = new StringBuilder(s.trim());
        // str.reverse();
        // int i = 0;
        // for(i = 0; i < s.trim().length(); i++) {
        //     if(str.charAt(i) == ' ')
        //         break;
        // }
        // return i;
        
        //Solution 3
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
}
