/* Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty). */

class MyStack {
    /*Solution 1:
    Pop operation is costly. Rear end of queue is the top of stack. 
    Push operation takes O(1). For pop operation, move all elements to 
    another queue 2, except the last 2 elements. Make the second last element as top.
    Now swap the 2 queues.
    Or simply, in every iteration, change top as the element removed, till the queue1
    has only 1 item. Then pop the last element.
    Pop the last element. If there is only 1 element in queue1, then simply pop it.
    For peek, simply return top. For empty, check if queue1 is empty.
    
    Solution 2:
    This approach also involves the use of 2 queues. In this, the push operation is costly.
    The front of the queue1 contains the top of stack. 
    To push, add the element to queue2. Then push all elements from queue1 to queue2. 
    Then swap queue1 and queue2.
    
    Solution 3:
    Use 1 queue instead of 2. The front of queue contains the top of stack, 
    so pop operation is O(1).
    For pushing, first add the new element x, 
    then using a while loop for (size - 1) times,
    add the removed items from queue1 to queue1.
    Empty() method is the same for all 3 solutions.
    */

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    private int top;
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    /** Push element x onto stack. */
    public void push(int x) {
        //Solution 1
        // top = x;
        // queue1.add(x);
        
        //Solution 2
        // queue2.add(x);
        // top = x;
        // while(!queue1.isEmpty()) {
        //     queue2.add(queue1.remove());
        // }
        // Queue<Integer> temp = queue1;
        // queue1 = queue2;
        // queue2 = temp;
        
        //Solution 3
        queue1.add(x);
        int len = queue1.size();
        for(int i = 1; i < len; i++)
            queue1.add(queue1.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //Solution 1
        // while(queue1.size() > 1) {
        //     top = queue1.remove();
        //     queue2.add(top);
        // }
        // int x = queue1.remove();
        // Queue<Integer> temp = queue1;
        // queue1 = queue2;
        // queue2 = temp;
        // return x;
        
        //Solution 2
        // int x = queue1.remove();
        // if(!queue1.isEmpty())
        //     top = queue1.peek();
        // return x;
        
        //Solution 3
        int x = queue1.poll();
        return x;
    }
    
    /** Get the top element. */
    public int top() {
        //Solution 1
        //return top;
        
        //Solution 2 and 3
        int x = queue1.peek();
        return x;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        //Solution 1, 2 and 3
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
