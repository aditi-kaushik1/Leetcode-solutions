/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.*/


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

/*Reference video: https://www.youtube.com/watch?v=K7LyJTWr2yA*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //Recursive method
        //Tree is symmetric if empty
//         if(root == null)
//             return true;
//         return isSym(root.left, root.right);
//     }
    
//     public boolean isSym(TreeNode left, TreeNode right){
//         //Check if left or right are null, then they must be equal.
//         if(left == null || right == null)
//           return left == right;
//         //Check if they are not null, then their values must be same.
//         if(left.val != right.val)
//             return false;
//         return isSym(left.left, right.right) && isSym(left.right, right.left);
        
        //Iterative method
        //Check the leetcode solutions page.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
    }
         return true;
}
}
