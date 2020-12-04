/*You are keeping score for a baseball game with strange rules. 
The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. 
You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:

An integer x - Record a new score of x.
"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record.*/


class Solution {
    public int calPoints(String[] ops) {
        /*Solution 1, using new list*/
//         int sum = 0;
//         List<Integer> list = new ArrayList<>();
//         for(int i = 0;i < ops.length; i++){
//         if(ops[i].equals("+")){
//             list.add(list.get(list.size()-1) + list.get(list.size()-2));
//         }
//         else if(ops[i].equals("C"))
//             list.remove(list.size()-1);
//         else if(ops[i].equals("D")){
//             int v = 2*list.get(list.size()-1);
//             list.add(v);}
//         else
//             list.add(Integer.parseInt(ops[i]));
// }
//         for(int i = 0; i < list.size(); i++){
//             sum += list.get(i);
//         }
//         return sum;
        
        /*Solution 2*/
        /*Learnt from solution section on leetcode*/
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(String e : ops){
            if(e.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }
            else if(e.equals("C")){
                stack.pop();
            }
            else if(e.equals("D")){
                stack.push(2*stack.peek());
            }
            else{
                stack.push(Integer.valueOf(e));
            }
        }
        for(Integer s : stack){
            sum += s;
        }
        return sum;
}
}
