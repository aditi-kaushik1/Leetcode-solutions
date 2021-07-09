/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. */

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
    public List<Integer> rightSideView(TreeNode root) {
        //BFS approach
        // List<Integer> list = new ArrayList<>();
        // if(root == null)
        //     return list;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i = 0; i < size; i++) {
        //         TreeNode temp = q.remove();
        //         if(i == size - 1)
        //             list.add(temp.val);
        //         if(temp.left != null)
        //             q.add(temp.left);
        //         if(temp.right != null)
        //             q.add(temp.right);
        //     }
        // }
        // return list;
        
        //DFS approach
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }
    
    public void helper(TreeNode root, List<Integer> list, int depth) {
        if(root == null)
            return;
        
        if(depth == list.size())
            list.add(root.val);
        
        helper(root.right, list, depth + 1);
        helper(root.left, list, depth + 1);
    }
}
