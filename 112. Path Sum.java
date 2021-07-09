/* Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children. */

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return helper(root, targetSum);
    }
    
    public boolean helper(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == targetSum;
        return helper(root.left, targetSum - root.val) || helper(root.right, targetSum - root.val);
    }
}
