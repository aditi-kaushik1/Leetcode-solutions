/* Given a singly linked list, return a random node's value from the linked list. 
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space? */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    /* Algorithm:
    Make head and count as global variables so that both methods can access it.
    Find length of Linked List.
    Generate a random number from 0 to length - 1.
    Traverse the linked list till we don't get the value of the node at that index. */
    ListNode head;
    int count;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, 
        so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        count = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            count++;
        }
        this.count = count;
    }
    
     /** Returns a random node's value. */
     public int getRandom() {
         //Generate a random number.
        Random rand  = new Random();
        int randInt = rand.nextInt(count);
        //Traverse through list again to reach node at value randInt.
        ListNode temp = head;
        int ptr = 0;
        while(ptr != randInt && temp.next != null){
            temp = temp.next;
            ptr++;
        }
        return temp.val;
     }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
