/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin. */

class MinStack {
    /* Solution 1: Use 2 stacks, 2nd stack stores only minimum value.
    
    Solution 2: Use single stack. Use a variable minElement.
    Apply proper operations to make use of flag to indicate 
    that the smallest element is being removed.
    
    Solution 3: https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
    Using linked list. The head will always store the top of stack. */

    //Solution 2 doesn't work if extremely large values of int are given, 
    //because 2*int might get out of range of int.
    Node head;
    //int minElement;
    //Stack<Integer> stackHelper;
    public MinStack() {
        //stack = new Stack<>();
        //stackHelper = new Stack<>();
        //minElement = -1;
    }
    
    public void push(int val) {
        //Solution 1
        //Push element in the stack.
        //Check if this element is smaller than stackHelper's top,
        //then push it in stackHelper.
        // stack.push(val);
        // if(stackHelper.isEmpty() || stackHelper.peek() >= val)
        //     stackHelper.push(val);
        // if(stack.isEmpty()) {
        //     stack.push(val);
        //     minElement = val;
        //     return;
        // }
        // if(val < minElement) {
        //     stack.push(2*val - minElement);
        //     minElement = val;
        // }
        // else
        //     stack.push(val);
        
        //Solution 3
        if(head == null)
            head = new Node(val,val);
        else
            head = new Node(val,Math.min(val,head.minimum),head);
    }
    
    public void pop() {
        //Solution 1
        //Check if the stackHelper is not empty and it's top
        //element is equal to stack's top element, then pop both.
        //int a = stack.pop();
        // if(stackHelper.peek().equals(stack.pop()))
        //     stackHelper.pop();
        
        //Solution 2
        // if(stack.peek() < minElement)
        //     minElement = 2 * minElement - stack.pop();
        // else
        //     stack.pop();
        
        //Solution 3
        head = head.next;  
    }
    
    public int top() {
        //Solution 1
        //return stack.peek();
        
        //Solution 2
        // if(stack.peek() < minElement)
        //     return minElement;
        // else
        //     return stack.peek();
        
        //Solution 3
        return head.data;
    }
    
    public int getMin() {
        //Solution 1
        //return stackHelper.isEmpty() ? -1 : stackHelper.peek();
        
        //Solution 2
        // if(stack.isEmpty())
        //     return -1;
        // return minElement;
        
        //Solution 3
        return head.minimum;
    }
}

public class Node {
    int data;
    int minimum;
    Node next;
    
    public Node(int data, int minimum) {
        this.data = data;
        this.minimum = minimum;
        this.next = null;
    }
    
    public Node(int data, int minimum, Node next) {
        this.data = data;
        this.next = next;
        this.minimum = minimum;
    }
}

//Solution 4
//Instead of using a linked list, store an int pair in stack.

// class MinStack {
//     Stack<int[]> stack = new Stack<>();
//     /** initialize your data structure here. */
//     public MinStack() {
        
//     }
    
//     public void push(int val) {
//         if(stack.isEmpty()) {
//             stack.push(new int[]{val, val});
//             return;
//         }
//         int x = stack.peek()[1];
//         stack.push(new int[]{val, Math.min(x, val)});
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek()[0];
//     }
    
//     public int getMin() {
//         return stack.peek()[1];
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
