/* You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself. 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?*/

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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        int ans = 0;
        
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            int x = stack1.pop() + stack2.pop() + carry;
            ans = x % 10;
            carry = x /10;
            ListNode curr = new ListNode(ans);
            dummyHead.next = curr;
            dummyHead = curr;
        }
        
        while(!stack1.isEmpty()) {
            int x = stack1.pop() + carry;
            ans = x % 10;
            carry = x / 10;
            ListNode curr = new ListNode(ans);
            dummyHead.next = curr;
            dummyHead = curr;
        }
        
        while(!stack2.isEmpty()) {
            int x = stack2.pop() + carry;
            ans = x%10;
            carry = x / 10;
            ListNode curr = new ListNode(ans);
            dummyHead.next = curr;
            dummyHead = curr;
        }
        
        if(carry != 0) {
            ListNode a = new ListNode(carry);
            dummyHead.next = a;
        }
        
        ListNode newHead = reverseList(head.next);
        return newHead;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        ListNode nex = curr;
        while(nex != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
}
