/* You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem. */


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // /*Solution 1*/
        // //We use the concept of level order traversal question
        // if(root == null)
        //     return root;
        // //Create a queue and add root to it (just like other tree questions)
        // Queue<Node> queue = new LinkedList<>();
        // queue.add(root);
        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++){
        //         Node current = queue.poll();
        //             //We need to stop when we reach the last node of any level
        //             if(i != size-1)
        //                 current.next = queue.peek();
        //         //The next element in queue is current.next.
        //         if(current.left != null)
        //             queue.add(current.left);
        //         if(current.right != null)
        //             queue.add(current.right);
        //         //After for loop ends, next level is reached
        //     }
        // }
        //return root;
        
        /*Solution 2*/
        //USe DFS on left children and BFS on levels 
        /*No need of queue for this, just change the value of next*/
        /*More efficient method, no need to make a queue. */
        if(root == null)
            return root;
        //To keep track whether entire tree has been traversed or not
        Node start = root;
        while(start != null){
            //current is used to keep track of whether the current level 
            // has been traversed or not.
            Node current = start;
            while(current != null){
                //Same parent case
                if(current.left != null)
                    current.left.next = current.right;
                //For different parent case
                if(current.right != null && current.next != null)
                    current.right.next = current.next.left;
                //Traversing the same level
                current = current.next;
            }
            //We are basically doing depth first search on entire tree and
            // choosing the leftmost child at each level.
            start = start.left;
        }
        return root;
    }
}
