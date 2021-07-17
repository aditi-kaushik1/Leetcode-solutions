/* You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.*/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode p = l1;
        ListNode q = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode l3 = dummyHead;
        
        int carry = 0;
        
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            int currSum = x + y + carry;
            int lastDigit = currSum % 10;
            carry = currSum/10;
            
            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;
            
            if(p != null) p = p.next;
            if(q != null) q = q.next;
            l3 = l3.next;
        }
        
        if(carry != 0)
            l3.next = new ListNode(carry);
        return dummyHead.next;
    }
}
