/* Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as
a binary tree in which the left and right subtrees of every node differ in height by no more than 1. 

Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104*/

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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(balanceFactor(root) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public int balanceFactor(TreeNode root) {
        return Math.abs(height(root.left) - height(root.right));
    }
}
