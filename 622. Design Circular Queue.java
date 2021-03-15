/* Design your implementation of the circular queue. 
The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. 
It is also called "Ring Buffer". */

class MyCircularQueue {
    int front;
    int rear;
    int size;
    int capacity;
    int[] queue;
    public MyCircularQueue(int k) {
        front = -1;
        rear = -1;
        size = 0;
        capacity = k;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull() == true)
            return false;
        else if(front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            size = 1;
            queue[0] = value;
            return true;
        }
        else {
            rear = (rear + 1) % capacity;
            size++;
            queue[rear] = value;
            return true;
     }
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        else if(size == 1) {
            front = -1;
            rear = -1;
            size = 0;
        }
        else {
            front = (front + 1) % capacity;
            size --;
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
