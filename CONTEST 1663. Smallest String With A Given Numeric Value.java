/*The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, 
so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. 
For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, 
either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.*/


class Solution {
    public String getSmallestString(int n, int k) {
        /*Solution 1*/
       char[] ans= new char[n];
        int sum = n;
        for(int i = 0; i < n ; i++){
            ans[i] = 'a';
        }
        for (int i = n-1; i >= 0;){
            if(sum == k)
                return new String(ans);
            if(ans[i] == 'z')
                i--;
            else{
                sum++;
                ans[i]++;
        }
        }
        return new String(ans);
        
      
        /*Solution 2*/
        //Code didn't run due to multiple errors.
    //     int[] array = new int[n];
    //     int sum = 0;
    //     if(n > k)
    //         return "";
    //     for(int i = 0; i < n ; i++){
    //         //Making every alphabet "a" first
    //         array[i] = 1;
    //         sum += array[i];
    //     }
    //     if(sum == k)
    //         return getOutput(array,n);
    //     for(int i = n - 1; i >= 0 ; i--){
    //         for(int j = 1; j < 27 ; j++){
    //             array[i]++;
    //             if(sum++ == k)
    //                 return getOutput(array,n);
    //         }
    //     }
    //     return "";
    // }
    // public String getOutput(int[] arr, int n){
    //      String str = null;
    //     for(int i = 0; i < n ;i++){
    //         str += Character.toString((char)arr[i]);
    //     }
    //     return str;  
    }
}

