/* Given the root of a binary tree, return the inorder traversal of its nodes' values. */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
           //Solution 1
           //Using recursion
//         if(root == null)
//             return list;
//         inorderTraversal(root.left);
//         list.add(root.val);
//         inorderTraversal(root.right);
        
//         return list;
        
        //Solution 2
        //Using stacks
//         Stack<TreeNode> stack = new Stack<>();
//         List<Integer> list = new ArrayList<>();
//         if(root == null)
//             return list;
//         TreeNode curr = root;
//         while(curr != null || !stack.isEmpty()) {
//             while(curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = stack.pop();
//             list.add(curr.val);
//             curr = curr.right;
//         }
//         return list;
        
        //Solution 3
        //Morris Traversal
        List<Integer> list = new ArrayList<>();
        TreeNode curr, pre;
        if(root == null)
            return list;
        curr = root;
        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }
            else {
                pre = curr.left;
                while(pre.right != null && pre.right != curr) 
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}

/* The first solution solves the problem recursively.

The second problem uses a stack. Use a node curr = root. 
While curr does not become equal to null or the stack does not become empty, keep iterating in the while loop. 
Another while loop inside keeps iterating untill curr == null. Push the left children in stack and keep moving left. 
Now, at this point curr = null. 
Now, change curr = stack.pop(). Then, move right by changing curr = curr.right.

The third solution is the Morris Traversal, which makes use of a concept called threaded binary tree, 
in which extra connections are made to facilitate the traversal of tree. 
The tree is altered, but before exiting, the tree is changed back to it's original form. Use curr and pre(predecessor). 
Put curr = root. Use a while loop that works untill curr != null. If curr does not have a left child, then simply visit it and move to the right. 
Else, put pre = curr.left. Now make pre move to the right untill it's right = null or right = curr. At this point, the while loop gets over. 
Now, we need to check if pre.right == null, then make pre.right = curr. (For pre order traversal, visit curr now itself). Then change curr to curr.left.
Otherwise (if pre.right == curr), change pre.right = null. Then, visit curr (don't do it for preorder traversal). Then, change curr to curr.right.
*/
