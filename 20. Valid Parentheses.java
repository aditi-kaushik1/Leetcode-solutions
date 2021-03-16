/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.*/

class Solution {
    public boolean isValid(String s) {
        //Solution 1
        //Algorithm:
        /*Corner case where first element is a closing bracket. 
        But in this solution, it is not necessary to specify that.
        Declare a stack and insert the characters of the string in it 
        if they are opening brackets.
        As soon as you encounter a closing bracket, 
        compare it with the element at the top of the stack.
        If they are corresponding, then pop the opening bracket, else return false.
        When the end of the string is reached, 
        iff the stack is empty, then the string is valid.*/
        
        //Length of string should be even for it to be valid, coz they occur in pairs.
       if(s.length() % 2 != 0)
           return false;
        
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            
            //Always put the code checking for empty stack first, 
            //because when put after stack.peek, runtime error shows up
            //because we are asking the system to look up for a character
            // in a stack which is empty.
            
            else if(!stack.empty() && c == '}' && stack.peek() == '{')
                stack.pop();
            
            else if(!stack.empty() && c == ']' && stack.peek() == '[')
                stack.pop();
            
            else if(!stack.empty() && c == ')' && stack.peek() == '(')
                stack.pop();
            else
                stack.push(c);
        }
        return stack.empty();
        
        //Solution 2
        // Stack<Character> stack = new Stack<>();
        // for(int i = 0; i < s.length(); i++) {
        //     if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
        //         stack.push(s.charAt(i));
        //     else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(')
        //         stack.pop();
        //     else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{')
        //         stack.pop();
        //     else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[')
        //         stack.pop();
        //     else
        //         return false;
        // }
        // return stack.isEmpty();
        
        //Solution 3
        // Stack<Character>stack = new Stack<>();
        // for(Character c : s.toCharArray()) {
        //     if(c == '(')
        //         stack.push(')');
        //     else if(c == '{')
        //         stack.push('}');
        //     else if(c == '[')
        //         stack.push(']');
        //     else if(stack.isEmpty() || stack.pop() != c)
        //         return false;
        // }
        // return stack.isEmpty();
        
        //Solution 4
        //Check leetcode solution page
//         Stack<Character> stack = new Stack<>();
//         for(char c : s.toCharArray()) {
//             if(mapping.containsKey(c)) {
//                 char topElement = stack.isEmpty() ? '#' : stack.pop();
//                 if(topElement != mapping.get(c))
//                     return false;
//             }
//             else
//              stack.push(c);
//         }
//         return stack.isEmpty();
//     }
//         private HashMap<Character, Character> mapping;
//         public Solution() {
//             mapping = new HashMap<Character, Character>();
//             mapping.put(')','(');
//             mapping.put('}','{');
//             mapping.put(']','[');
    }
}    
