/* Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity. */

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
    public ListNode oddEvenList(ListNode head) {
        //Solution 1
        //https://www.youtube.com/watch?v=C_LA6SOwVTM
        //Nick White video
        
//         if(head == null)
//             return head;
        
//         ListNode odd = head;
//         ListNode even = head.next;
//         ListNode evenHead = even;
        
//         while(even != null && even.next != null) {
//             odd.next = even.next;
//             odd = odd.next;
//             even.next = odd.next;
//             even = even.next;
//         }
//         odd.next = evenHead;
//         return head;
        
        //Solution 2
        //https://www.youtube.com/watch?v=YE9ggKeHeK0
        //Tech Dose video
        //2 times iteration required
        
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode end = head;
        int count = 0;
        while(end.next != null) {
            count++;
            end = end.next;
        }
        ListNode temp = head;
        count = (count % 2 == 1) ? (count/2) + 1 : count/2;
        while(count-- != 0) {
            end.next = temp.next;
            temp.next = temp.next.next;
            end.next.next = null;
            temp = temp.next;
            end = end.next;
        }
        return head;
    }
}
