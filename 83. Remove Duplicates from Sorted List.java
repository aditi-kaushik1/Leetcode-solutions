/* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well. */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //Solution 1
        //Using 2 while loops. but time complexity is O(n) only
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            ListNode temp = curr.next;
            while(temp != null && curr.val == temp.val) {
                ListNode x = temp.next;
                temp = null;
                temp = x;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
        
        //Solution 2
        // ListNode curr = head;
        // while(curr != null && curr.next != null) {
        //     if(curr.val == curr.next.val)
        //         curr.next = curr.next.next;
        //     else
        //         curr = curr.next;
        // }
        // return head;
    }
}
