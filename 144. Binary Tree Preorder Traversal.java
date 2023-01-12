//Given the root of a binary tree, return the preorder traversal of its nodes' values.

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
    //List<Integer> ans = new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root == null)
    //         return ans;
    //     ans.add(root.val);

    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
                       //     return ans;
    // }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            ans.add(stack.peek().val);

            while(stack.peek().left != null) {
                TreeNode leftChild = stack.peek().left;
                stack.push(leftChild);
                ans.add(leftChild.val);
            }

            while(!stack.isEmpty() && stack.peek().right == null) {
                stack.pop();
            }

            if(stack.isEmpty())
                return ans;
            
            stack.push(stack.pop().right);
        }
        return ans;
    }
}
