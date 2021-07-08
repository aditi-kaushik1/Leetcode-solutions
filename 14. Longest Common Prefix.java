/* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters. */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Use sorting
        //We can sort the array in lexicographical order
        //and then find the common prefix between 1st and last terms
        //(2 most dissimilar terms).
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        Arrays.sort(strs);
        int min = Math.min(strs[0].length(), strs[strs.length - 1].length());
        int i = 0;
        while(i < min && strs[0].charAt(i) == strs[strs.length - 1].charAt(i))
            i++;
        return strs[0].substring(0, i);
        
        /*This problem can be solved using divide and conquer as well as
        binary search too, but they are not optimised 
        because of extra space and time complexity. */
        //Solution using Tries
        // if(strs.length == 0)
        //     return "";
        // if(strs.length == 1)
        //     return strs[0];
        // for(String s : strs)
        //     insert(s);
        // Node current = root;
        // String ans = "";
        // int i = 0;
        // while(true) {
        //     if(current.children.isEmpty() || current.isEndOfWord || current.children.size() > 1)
        //         return ans;
        //     ans += strs[0].charAt(i);
        //     current = current.children.get(strs[0].charAt(i++));
        }
        
        //Solution
        /*Character by character matching
        It is more optimised, find the length of the smallest prefix.
        The longest prefix cannot be longer than this.
        Now see upto which index all the elements have the same character. */
        
        // int min = min(strs);
        // String result = "";
        // for(int i = 0; i < min; i++) {
        //     char c = strs[0].charAt(i);
        //     for(int j = 1; j < strs.length; j++)
        //         if(strs[j].charAt(i) != c)
        //             return result;
        //     result += c;
        // }
        // return result;
        
        //Solution
        /*Using word by word matching
        Take 1 pair ata time, find the longest prefix, 
        then take another string and find it's longest prefix with
        the previous longest prefix. */
        
//         String ans = strs[0];
//         for(int i = 1; i < strs.length; i++)
//             ans = helper(ans, strs[i]);
//         return ans;
//     }
    
//     public String helper(String s1, String s2) {
//         int n1 = s1.length();
//         int n2 = s2.length();
//         String str = "";
//         for(int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
//             if(s1.charAt(i) != s2.charAt(j))
//                 return str;
//             str += s1.charAt(i);
//         }
//         return str;
//   }
    
    // public int min(String[] strs) {
    //     int x = strs[0].length();
    //     for(int i = 1; i < strs.length; i++) {
    //         x = Math.min(strs[i].length(), x);
    //     }
    //     return x;
    // }
    
    //Solution
    /*Insert the words in trie.
    Then traverse the trie untill we get to a node
    which has no children(end of word), or has more than 1 children
    (branching is not allowed). */
    
//     public class Node {
//         char value;
//         HashMap<Character, Node> children = new HashMap<>();
//         boolean isEndOfWord;
        
//         Node(char value) {
//             this.value = value;
//         }
//     }
    
//     Node root = new Node(' ');
    
//     public void insert(String word) {
//         Node current = root;
//         for(char ch : word.toCharArray()) {
//             if(!current.children.containsKey(ch))
//                 current.children.put(ch, new Node(ch));
//             current = current.children.get(ch);
//         }
//         current.isEndOfWord = true;
//     }
}
