/* Given the root of a binary tree, return all root-to-leaf paths in any order.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list, "");
        return list;
    }
    
    public void helper(TreeNode root, List<String> list, String str) {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            str += root.val;
            list.add(str);
            str = "";
            return;
        }
        
        str = str + root.val + "->";
        
        helper(root.left, list, str);
        helper(root.right, list, str);
    }
}
