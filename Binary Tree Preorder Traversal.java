/* Given the root of a binary tree, return the preorder traversal of its nodes' values. */

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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        //Recursive solution
        // if(root == null)
        //     return list;
        // list.add(root.val);
        // preorderTraversal(root.left);
        // preorderTraversal(root.right);
        // return list;
        
        //Iterative solution
        if(root == null)
            return list;
        TreeNode pre, curr;
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
                    list.add(curr.val);
                    curr = curr.left;
                }
             
                else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
