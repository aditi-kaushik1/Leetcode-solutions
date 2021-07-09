/* You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. 
If such a node does not exist, return null. */

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
    public TreeNode searchBST(TreeNode root, int val) {
        //Recursive solution
        // if(root == null)
        //     return null;
        // if(root.val == val)
        //     return root;
        // return val < root.val ? searchBST(root.left, val) : 
        // searchBST(root.right, val);
        
        //Iterative solution
        while(root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
