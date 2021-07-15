/* Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. 
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list. 
Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1. */

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
    public int getDecimalValue(ListNode head) {
        //Solution 1
        /*Inefficient approach because no primitive data type 
        can store 30 digits. */
        // StringBuilder res = new StringBuilder();
        // ListNode curr = head;
        // while(curr != null) {
        //     res.append(curr.val);
        //     curr = curr.next;
        // }
        // long x = Long.parseLong(res.toString());
        // System.out.println(x);
        // int powOf2 = 0;
        // int answer = 0;
        // while(x != 0) {
        //     answer += ((x%10) * Math.pow(2, powOf2++));
        //     x /= 10;
        // }
        // return answer;
        
        //Solution 2
//         int length = 0;
//         ListNode curr = head;
//         while(curr != null) {
//             length++;
//             curr = curr.next;
//         }
        
//         int ans = 0;
//         curr = head;
//         while(curr != null) {
//             ans += curr.val* Math.pow(2, --length);
//             curr = curr.next;
//         }
//         return ans;
        
        //Solution 3
        //Using bit manipulation
        int num = 0;
        ListNode curr = head;
        while(curr != null) {
            num = (num << 1) | curr.val;
            curr = curr.next;
        }
        return num;
    }
}
