/* Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node. */

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
    public ListNode middleNode(ListNode head) {
        //Solution 1
        //Using single iteration and 2 pointers
        //Be careful with null pointer exception
        // ListNode temp1 = head;
        // ListNode temp2 = head;
        // while(temp2 != null && temp2.next != null) {
        //     temp1 = temp1.next;
        //     temp2 = temp2.next.next;
        // }
        // return temp1;
        
        //Solution 2
        //By calculating length and returning n/2th element.
        // int count = 0;
        // ListNode temp = head;
        // while(temp != null) {
        //     temp = temp.next;
        //     count++;
        // }
        // int n = count/2;
        // temp = head;
        // while(n-- != 0) {
        //     temp = temp.next;
        // }
        // return temp;
        
        //Solution 3
        //Check leetcode solution page
        //Convert list to array and then access n/2th element
        ListNode[] arr = new ListNode[100];
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            arr[count++] = temp;
            temp = temp.next;
        }
        return arr[count/2];
    }
}
