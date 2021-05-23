/* Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false. 
Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
Follow up: Can you solve it using O(1) (i.e. constant) memory? */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Solution 1
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode temp = head;
        // while(temp != null) {
        //     if(set.contains(temp))
        //         return true;
        //     set.add(temp);
        //     temp = temp.next;
        // }
        // return false;
        
        //Solution 2
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
        
        //Solution 3
        // while(head != null) {
        //     if(head.val == Integer.MIN_VALUE)
        //         return true;
        //     head.val = Integer.MIN_VALUE;
        //     head = head.next;
        // }
        // return false;
        
        //Solution 4
        // ListNode temp = new ListNode();
        // while(head != null) {
        //     if(head.next == temp)
        //         return true;
        //     ListNode nex = head.next;
        //     head.next = temp;
        //     head = nex;
        // }
        // return false;
        
        //Solution 5
//         ListNode slow = head;
//         ListNode fast = head;
//         int prevDist = -1;
//         int currDist = 0;
//         while(prevDist < currDist && fast != null) {
//             prevDist = currDist;
//             fast = fast.next;
//             currDist = distance(slow, fast);
//         }
//         if(fast == null)
//             return false;
//         return true;
//     }
    
//     private int distance(ListNode slow, ListNode fast) {
//         int count = 0;
//         ListNode x = slow;
//         while(x != fast) {
//             x = x.next;
//             count++;
//         }
//         return count;
        
        //Solution 6
        //Create a visited flag, in every node.
    }
}
