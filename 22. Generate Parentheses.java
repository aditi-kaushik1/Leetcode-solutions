/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 
Constraints:

1 <= n <= 8 */

class Solution {
    List<String > list = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        return generateHelper(n, n, "");
    }
    
    public List<String> generateHelper(int open, int closed, String op) {
        if(open == 0 && closed == 0) {
            list.add(op);
            return list;
        }
        
        if(open > 0) {
            String op1 = op;
            op1 += "(";
            
            generateHelper(open - 1, closed, op1);
        }
        
        if(closed > open) {
            String op2 = op;
            op2 += ")";
            
            generateHelper(open, closed - 1, op2);
        }
        return list;
    }
}
