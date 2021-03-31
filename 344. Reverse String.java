/* Write a function that reverses a string. The input string is given as an array of characters s. */

class Solution {
    public void reverseString(char[] s) {
        //Solution 1
        //By allocating extra memory
        //Not suitable
        //Time complexity is )(2*n) and space is O(n).
        // char[] newS = new char[s.length];
        // int j = 0;
        // for(int i = s.length - 1; i >= 0; i--) {
        //     newS[j++] = s[i];
        // }
        // for(int i = 0; i < s.length; i++) {
        //     s[i] = newS[i];
        // }
        
        //Solution 2
        //Use 2 pointers
        //Swap characters at those positions.
        //First think and apply on a test case, to get the indices right.
        // int j = s.length - 1;
        // for(int i = 0; i < s.length/2; i++) {
        //     char temp = s[i];
        //     s[i] = s[j];
        //     s[j] = temp;
        //     j--;
        // }
        
        //Solution 3
        //Not writing j, tweaking solution 2, to get answer.
        // for(int i = 0; i < s.length/2; i++) {
        //     char temp = s[i];
        //     s[i] = s[s.length - i - 1];
        //     s[s.length - i - 1] = temp;
        // }
        
        //Solution 4
        //Using recursion
        helper(s,0,s.length - 1);
    }
    public void helper(char[] s, int left, int right) {
        if(left >= right)
            return;
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        helper(s,left,right);
    }
}
