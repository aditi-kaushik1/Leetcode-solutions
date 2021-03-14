/*Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).*/

class MyQueue {
    /*Solution 1 -
    By making the enqueue operation costly
    Hence, the dequeue operation won't be costly and the top element of the stack 
    is the front of the queue, since it can easily be removed and peek() is also not costly.
    To enqueue(), move all elements from stack1 to stack2, the top of stack2 contains 
    the rear end of queue. Then insert the element and then push all of these 
    from stack2 to stack1. It is not optimised solution as the elements 
    have to be pushed and popped twice for enqueue().
    
    Solution 2-
    By making dequeue operation costly : Amortized O(1) per operation for dequeue.
    Hence, enqueue is not costly, means the top of stack1 has the rear end of queue.
    On pushing to stack2, the top of stack2 will have the front of queue.
    For enqueue(), O(1) is the time complexity.
    For peek() and pop(), check if stack1 and stack2 are empty, then throw exception.
    If stack1 is not empty and stack2 is empty, push all items from stack1 to stack2.
    Now pop the top element from stack2, and let the items remain in stack2.
    If stack2 is not empty, pop the element from it.
    If enqueue() is performed after it, the item is simply pushed in stack1.
    */

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    private int front;
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        //Solution 1
        // if(stack1.isEmpty())
        //     stack1.push(x);
        // else {
        //     while(!stack1.isEmpty())
        //         stack2.push(stack1.pop());
        //     stack1.push(x);
        //     while(!stack2.isEmpty())
        //         stack1.push(stack2.pop());
        // }
        
        //Solution 2
        if(stack1.isEmpty())
            front = x;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //Solution 1
        // int x = stack1.pop();
        // return x;
        
        //Solution 2
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            int x = stack2.pop();
            if(!stack2.isEmpty())
                front = stack2.peek();
            return x;
        }
        else {
            int x = stack2.pop();
            if(!stack2.isEmpty())
                front = stack2.peek();
            return x;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        //Solution 1
        // int x = stack1.peek();
        // return x;
        
        //Solution 2
        if(stack2.isEmpty())
            return front;
        else
            return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //Solution 1
        //return stack1.isEmpty();
        
        //Solution 2
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/*     Stack representation:

        |1_| (front = 1) (peek)
        |2_| (after popping, change front = 2)
        |3_|
        |4_|
        |5_|  (use stack2 to push element after 5) 
        
        Queue representation:
         _____________
        |_1_|2|3|4|5__|
        
        front = 1             rear = 5
*/

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
