/* Given the root of a binary tree, invert the tree, and return its root. */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        //Solution 1
        //Recursive solution
        
//         helper(root);
//         return root;
//     }
    
//     public void helper(TreeNode root) {
        // if(root == null)
        //     return;
        // if(root.left == null && root.right == null)
        //     return;
        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // root.left = right;
        // root.right = left;
        // helper(root.left);
        // helper(root.right);
        
        //Solution 2
        //Iterative solution
        
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return null;
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null)  q.add(curr.left);
            if(curr.right != null)  q.add(curr.right);
        }
        return root;
    }
}
