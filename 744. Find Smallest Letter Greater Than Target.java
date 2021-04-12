/* Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, 
find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'. */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        //Solution 1
        //Binary search
        char res = '#';
        int left = 0;
        int right =letters.length - 1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left)/2;
            if(letters[mid] <= target)
                left = mid + 1;
            else if(letters[mid] > target) {
                res = letters[mid];
                right = mid - 1;
            }
        }
        return (res != '#') ? res : letters[0];
        
        //Solution 2
        //Linear scan
        //Using ASCII values is important, because the
        //alphabet whose next alphabet needs to be found out,
        //might not be present in the array.
        // for(char c : letters)
        //     if(c > target)
        //         return c;
        // return letters[0];
        
        //Solution 3
        //Check leetcode solution page
        //Storing the seen alphabets in an array or set.
        //This takes up only 0(1) space,
        // because there can be at max 26 elements in the array.
        // boolean[] seen = new boolean[26];
        // for(char c : letters)
        //     seen[c - 'a'] = true;
        // while(true) {
        //     target++;
        //     if(target > 'z')
        //         return letters[0];
        //     if(seen[target - 'a'])
        //         return target;
        // }
    }
}
