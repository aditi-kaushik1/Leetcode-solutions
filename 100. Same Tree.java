/* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value. */

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p == null && q == null)
        //     return true;
        // if(p == null || q == null)
        //     return false;
        // if(p.val != q.val)
        //     return false;
        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        if(!check(p,q))
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode temp1 = q1.remove();
            TreeNode temp2 = q2.remove();
            if(!check(temp1, temp2))
                return false;
            if(temp1 != null) {
                q1.add(temp1.left);
                q1.add(temp1.right);
            }
            if(temp2 != null) {
                q2.add(temp2.left);
                q2.add(temp2.right);
            }
        }
        return true;
    }
    
    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return p.val == q.val;
    }
}
