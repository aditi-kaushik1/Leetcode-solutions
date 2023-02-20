class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;
        int j = 0;
        String ans = "";
        int start = 0;
        while(i < len1 && j < len2) {
            if(start % 2 == 0) {
                ans += word1.charAt(i++);
            }
            else
                ans += word2.charAt(j++);
            start++;
        }

        if(i < len1) {
            ans += word1.substring(i);
        }

        if(j < len2) {
            ans += word2.substring(j);
        }
        return ans;
    }
}
