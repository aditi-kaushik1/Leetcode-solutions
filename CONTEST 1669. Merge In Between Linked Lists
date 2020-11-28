/*You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure incidate the result:

Build the result list and return its head.
Example 1:
Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
Example 2:
Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.
Constraints:
3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104 */


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
//Use linked list inserting a node in the middle concept.
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int lengthList1 = lengthOfList(list1);
        int lengthList2 = lengthOfList(list2);
        ListNode curr = list1;
        ListNode endCurr = list1;
        ListNode lastNodeList2 = list2;
        for(int i = 0; i < lengthList2 - 1; i++){
            lastNodeList2 = lastNodeList2.next;
        }
        for( int i = 0; i < a - 1 ; i ++){
            curr = curr.next;
            //Got the (a-1)th node
        }
        for(int j = 0; j <= b; j ++){
            endCurr = endCurr.next;
            //Got the b th node
        }
        curr.next = list2;
        lastNodeList2.next = endCurr;
        return list1;
    }
    int lengthOfList(ListNode x){
            int count  = 0;
            while(x != null){
                x = x.next;
                count ++;
            }
        return count;
    }
}
