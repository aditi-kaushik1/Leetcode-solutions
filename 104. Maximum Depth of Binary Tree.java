G/*iven the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1 */


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
    public int maxDepth(TreeNode root) {
        /*Solution 1*/
        /*Using queue*/
        // if(root == null)
        //     return 0;
        // Queue<TreeNode> queue = new LinkedList<>();
        // int depth = 0;
        // queue.add(root);
        // while(!queue.isEmpty()){
        //     depth ++;
        //     int size = queue.size();
        //     for(int i = 0; i < size; i ++){
        //         TreeNode current = queue.remove();
        //         if(current.left != null)
        //             queue.add(current.left);
        //         if(current.right != null)
        //             queue.add(current.right);
        //     }
        // }
        // return depth;
        
        /*Solution 2*/
        /*Using recursive function*/
        if(root == null)
            return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        
        if (lDepth > rDepth)
            return (1 + lDepth);
        else {
            return (1 + rDepth);
        }
    }
}
