/* You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        //Solution 1
        // int count = 0;
        // HashSet<Character> set = new HashSet<>();
        // for(char c : jewels.toCharArray())
        //     set.add(c);
        // for(char c : stones.toCharArray())
        //     if(set.contains(c))
        //         count++;
        // return count;
        
        //Solution 2
        int count = 0;
        for(char c : stones.toCharArray())
            if(jewels.indexOf(c) != -1)
                count++;
        return count;
    }
}
