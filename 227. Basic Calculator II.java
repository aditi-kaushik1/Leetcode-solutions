/* Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function. */


class Solution {
    public int calculate(String s) {
        /*Solution 1*/
        /*Using stack to store numbers*/
        // Stack<Integer> stack = new Stack<Integer>();
        // if(s == null || s.length() == 0)
        //     return 0;
        // int currentNumber = 0;
        // char operation = '+';
        // for(int i = 0; i < s.length(); i++){
        //     char currentChar = s.charAt(i);
        //     if(Character.isDigit(currentChar))
        //     currentNumber = (currentNumber * 10) + (currentChar - '0');
        //     if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) 
        //        || i == s.length() - 1){
        //         if (operation == '-')
        //             stack.push(-currentNumber);
        //         else if(operation == '*')
        //             stack.push(stack.pop() * currentNumber);
        //         else if(operation == '/')
        //             stack.push(stack.pop() / currentNumber);
        //         else if(operation == '+')
        //             stack.push(currentNumber);
        //         operation = currentChar;
        //         currentNumber = 0;
        //     }
        // }
        // int result = 0;
        // while(!stack.isEmpty()){
        //     result += stack.pop();
        // }
        // return result;
        
        /*Solution 2*/
        /*No use of stack, has constant space complexity. */
        if(s.length() == 0 || s == null)
            return 0;
        int currentNumber = 0;
        char operation = '+';
        int result = 0;
        int lastNumber = 0;
        for(int i = 0; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar))
                currentNumber = (currentNumber*10) + (currentChar - '0');
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1){
                if(operation == '+' || operation == '-'){
                    result += lastNumber;
                    lastNumber = (operation == '+')? (currentNumber) : (-currentNumber);
                }
                else if(operation == '*')
                    lastNumber = lastNumber * currentNumber;
                else if(operation == '/')
                    lastNumber = lastNumber / currentNumber;
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}
