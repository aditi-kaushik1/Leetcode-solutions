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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, "");
    }

    int ans = 0;

    public int helper(TreeNode root, String parent) {
        // if(root == null)
        //     return 0;
        // if(root.left != null && root.left.left == null && root.left.right == null)
        //     ans += root.left.val;
        // helper(root.left);
        // helper(root.right);
        // return ans;

        if(root == null)
            return 0;
        if(root.left == null && root.right == null && parent.equals("left"))
            ans += root.val;
        helper(root.left, "left");
        helper(root.right, "right");
        return ans;
    }
}
