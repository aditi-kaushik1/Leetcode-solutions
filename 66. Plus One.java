//Solution 1

//class Solution {
//    public int[] plusOne(int[] digits) {
//         int len = digits.length;
//         for(int i = len - 1; i >= 0; i--) {
//             if(digits[i] != 9) {
//                 digits[i]++;
//                 break;
//             }
//             else {
//                 digits[i] = 0;
//             }
//         }
        
//         if(digits[0] == 0) {
//             int[] res = new int[len + 1];
//             res[0] = 1;
//             return res;
//         }
        
//         return digits;
//     }
// }

//Solution 2

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        return helperPlusOne(digits, len - 1, len);
    }
    
    public int[] helperPlusOne(int[] digits, int index, int len) {
        if(index == -1) {
            int[] result = new int[len + 1];
            result[0] = 1;
            return result;
        }
        
        if(digits[index] != 9) {
            digits[index]++;
            return digits;
        }
        
        else {
            digits[index] = 0;
            return helperPlusOne(digits, index - 1, len);
        }
    }
}
