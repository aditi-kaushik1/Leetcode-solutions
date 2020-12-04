/*Design a queue that supports push and pop operations in the front, middle, and back.

Implement the FrontMiddleBack class:

FrontMiddleBack() Initializes the queue.
void pushFront(int val) Adds val to the front of the queue.
void pushMiddle(int val) Adds val to the middle of the queue.
void pushBack(int val) Adds val to the back of the queue.
int popFront() Removes the front element of the queue and returns it. If the queue is empty, return -1.
int popMiddle() Removes the middle element of the queue and returns it. If the queue is empty, return -1.
int popBack() Removes the back element of the queue and returns it. If the queue is empty, return -1.
Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example:

Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6]. */


class FrontMiddleBackQueue {
    
    //Solution learnt from : https://leetcode.com/problems/design-front-middle-back-queue/discuss/951997/Java-Using-LinkedList-Straightforward-1-Liners-All-Method
    LinkedList<Integer> queue;
    public FrontMiddleBackQueue() {
        queue = new LinkedList();
    }
    
    public void pushFront(int val) {
        queue.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        queue.add(queue.size()/2, val);
    }
    
    public void pushBack(int val) {
        queue.addLast(val);
    }
    
    public int popFront() {
        return queue.isEmpty() ? -1 : queue.removeFirst();
    }
    
    public int popMiddle() {
        return queue.isEmpty() ? -1 : queue.remove((queue.size() - 1) / 2);
    }
    
    public int popBack() {
        return queue.isEmpty() ? -1 : queue.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
