class Solution {
    public int minFlipsMonoIncr(String s) {
        int numOf0 = 0;
        int numOf1 = 0;
        int len = s.length();

        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '0')
                numOf0++;
            else
                numOf1++;
        }

        int countOf0 = 0;

        int minCount = Math.min(numOf0, numOf1);

        for(int i = 0; i < len; i++) {
            if(s.charAt(len - i - 1) == '0') {
                countOf0++;
            }

            if(s.charAt(len - i - 1) == '1') {
                numOf1--;
            }

            minCount = Math.min(minCount, countOf0 + numOf1);
        }
        return minCount;
    }
}

//010000110

//00110 -> 00111 (00000, 00001, 00011, 00111)
//010110 -> 000111
//00011000 -> 00000000

// 00000
// 00001
// 00011
// 00111
// 01111
// 11111
