class Solution {
    public String freqAlphabets(String s) {
        int i = 0;
        String ans = "";
        while(i < s.length()) {
            if(i < s.length() - 2 && s.charAt(i + 2) == '#') {
                ans += (char)(Integer.parseInt(s.substring(i, i + 2)) + 96);
                i += 3;
            }

            else {
                int a = s.charAt(i) - '0';
                ans += (char)(a + 96);
                i += 1;
            }
        }
        return ans;
    }
}
