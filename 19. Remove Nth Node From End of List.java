/* Given the head of a linked list, remove the nth node from the end of the list and return its head.
Follow up: Could you do this in one pass? */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Solution 1
        //Count length and return (len - n + 1)th element.
        // int count = 0;
        // ListNode temp = head;
        // while(temp != null) {
        //     temp = temp.next;
        //     count ++;
        // }
        // int x = count - n - 1;
        // //When node to be deleted is not present in the list.
        // if(x < -1)
        //     return null;
        // //When the head node has to be deleted.
        // if(x == -1) {
        //     temp = head.next;
        //     head.next = null;
        //     head = temp;
        //     return head;
        // }
        // temp = head;
        // while(x-- != 0) 
        //     temp = temp.next;
        // ListNode newNext = temp.next.next;
        // temp.next.next = null;
        // temp.next = newNext;
        // return head;
        
        // Solution 2
        // Keep 2 pointers, move the first one n times, 
        // then move both by a distance of 1 until one reaches the end
        //Case for a single element
        // if(head.next == null)
        //     return null;
        // ListNode temp = head;
        // while(n-- != 0 && temp != null)
        //     temp = temp.next;
        // ListNode slowTemp = head;
        // if(temp == null) {
        //     ListNode second = head.next;
        //     head.next = null;
        //     head = second;
        //     return head;
        // }
        // while(temp.next != null) {
        //     temp = temp.next;
        //     slowTemp = slowTemp.next;
        // }
        // temp = slowTemp.next.next;
        // slowTemp.next.next = null;
        // slowTemp.next = temp;
        // return head;
        
        //or
        
        //Check leetcode solution page for this approach
        //Instead of writing seperate piece of code for the case when 
        //head is to be deleted, introduce a dummy node whose next is head.
        //This will take care of null pointer exception in the case when head is 
        //to be deleted.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0; i < n + 1; i++)
            first = first.next;
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
