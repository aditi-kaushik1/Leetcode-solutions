/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. */

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
    //Solution 1
    //Use null instead of Integer.MIN_VALUE and Integer.MAX_VALUE.
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        
        return isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max);
    }
    
       //Solution 2
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
    
//     private boolean isValidBST(TreeNode root, long min, long max) {
//         if(root == null)
//             return true;
//         if(root.val <= min || root.val >= max)
//             return false;
        
//         return isValidBST(root.left, min, root.val) 
//             && isValidBST(root.right, root.val, max);
//     }
}
