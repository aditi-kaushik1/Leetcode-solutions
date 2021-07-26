/* Given a string s, return the string after replacing every uppercase letter with the same lowercase letter. */

 class Solution {
    public String toLowerCase(String s) {
        //Solution 1
        //return s.toLowerCase();
        
        //Solution 2
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch - 0 >= 65 && ch - 0 <= 90)
                str.append((char)(ch + 32));
            else
                str.append(ch);
        }
        return str.toString();
    }
}
