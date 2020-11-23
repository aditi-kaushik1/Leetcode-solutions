/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false */


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
    public boolean isCousins(TreeNode root, int x, int y) {
        //Reference video : https://www.youtube.com/watch?v=UyxnGWMvxwc
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean doesXexist = false;
            boolean doesYexist = false;
          for(int i = 0; i < size; i++){
            TreeNode current = q.poll();
            if(current.val == x)
                doesXexist = true;
              if(current.val == y)
                  doesYexist = true;
              if((current.left!=null && current.right!=null) && ((current.left.val == x && current.right.val == y) || (current.left.val == y && current.right.val == x)))
                 return false;
        if(current.left!=null)
                 q.add(current.left);
                 if(current.right!=null)
                     q.add(current.right);
          }
            if (doesXexist && doesYexist)
              return true;
        }
        return false;
    }
}
