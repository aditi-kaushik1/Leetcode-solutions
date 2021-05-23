/* Given the head of a singly linked list, reverse the list, and return the reversed list.
Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both? */

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
    public ListNode reverseList(ListNode head) {
      //Check leetcode solution page
        //Iterative solution
        // if(head == null || head.next == null)
        //     return head;
        // ListNode prev = head;
        // ListNode curr = head.next;
        // prev.next = null;
        // ListNode nex = head;
        // while(nex != null) {
        //     nex = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = nex;
        // }
        // head = prev;
        // return head;
        
        //Recursive solution
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
