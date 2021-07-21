/* Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:
Input: s = "leetcode"
Output: "leotcede"
Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters. */

class Solution {
    public String reverseVowels(String s) {
        //Instead of maintaining a long list, simply use
        //a string vowels = "aeiouAEIOU";
        if(s == null)
            return "";
        String list = "AEIOUaeiou";
        char[] arr = s.toCharArray();
        
        int j = s.length() - 1;
        int i = 0;
        
        while(i <= j) {
            if(list.contains("" + arr[i]) && list.contains(arr[j] + "")) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
               
            else {
                if(!list.contains(arr[i] + ""))
                    i++;
                if(!list.contains(arr[j] + ""))
                    j--;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int k = 0; k < arr.length; k++)
            ans.append(arr[k]);
        
        return ans.toString();
    }
}
