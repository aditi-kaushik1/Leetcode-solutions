/* Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.
It is guaranteed that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.
Constraints:
The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
0 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.

Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory? */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Solution 1
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode x = headA;
        // while(x != null) {
        //     set.add(x);
        //     x = x.next; 
        // }
        // ListNode y = headB;
        // while(y != null) {
        //     if(set.contains(y))
        //         return y;
        //     y = y.next;
        // }
        // return null;
        
        //Solution 2
        // ListNode x = headA;
        // ListNode y = headB;
        // while(x != null) {
        //     y = headB;
        //     while(y != null) {
        //         if(x == y)
        //             return x;
        //         y = y.next;
        //     }
        //     x = x.next;
        // }
        // return null;
        
        //Solution 3
        //Leetcode solution page
//         int len1 = 0;
//         int len2 = 0;
//         ListNode a = headA;
//         ListNode b = headB;
//         while(a != null) {
//             len1++;
//             a = a.next;
//         }
//         while(b != null) {
//             len2++;
//             b = b.next;
//         }
        
//         int diff = Math.abs(len1 - len2);
//         a = headA;
//         b = headB;
        
//         if(len1 > len2) {
//             while(diff-- != 0)
//                 a = a.next;
//         }
//         else {
//             while(diff-- != 0)
//                 b = b.next;
//         }
        
//         while(a != b) {
//             a = a.next;
//             b = b.next;
//         }
//         return a;
        
        //Solution 4
//         ListNode a = headA;
//         ListNode b = headB;
        
//         while(a != b) {
//             a = (a == null) ? headB : a.next;
//             b = (b == null) ? headA : b.next;
//         }
//         return a;
        
        //Solution 5
        int len1 = 0;
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = a;
        while(a != null) {
            len1++;
            b = a;
            a = a.next;
        }
        b.next = headA;
        
        a = headB;
        b = headB;
        while(a != null && b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if(a == b)
                break;
        }
        if(a == null || b == null || b.next == null) {
            a = headA;
            while(len1-- != 1) {
                a = a.next;
            }
            a.next = null;
            return null;
        }
        
        a = headB;
        while(a != b) {
            a = a.next;
            b = b.next;
        }
        a = headA;
        while(len1-- != 1) {
            a = a.next;
        }
        a.next = null;
        return b;
    }
}
