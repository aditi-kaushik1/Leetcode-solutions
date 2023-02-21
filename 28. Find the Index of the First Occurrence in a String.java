class Solution {
    public int strStr(String haystack, String needle) {
        int lenHay = haystack.length();
        int lenNeedle = needle.length();
        if(lenNeedle > lenHay)
            return -1;
        for(int i = 0; i < lenHay - lenNeedle + 1; i++) {
            if(needle.equals(haystack.substring(i, i + lenNeedle)))
                return i;
        }
        return -1;
    }
}
