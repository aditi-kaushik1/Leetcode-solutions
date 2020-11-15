/*Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.*/

/*Pretty good solution, even though Brute force used. No optimisation required*/
class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L')
                count+=1;
            else
                count-=1;
            if(count==0)
                num+=1;
        }
        return num;
    }
}
