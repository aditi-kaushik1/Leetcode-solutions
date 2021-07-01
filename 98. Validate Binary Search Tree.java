/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. */

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
    //Solution 1
    //Use null instead of Integer.MIN_VALUE and Integer.MAX_VALUE.
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        
        return isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max);
    }
    
       //Solution 2
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
    
//     private boolean isValidBST(TreeNode root, long min, long max) {
//         if(root == null)
//             return true;
//         if(root.val <= min || root.val >= max)
//             return false;
        
//         return isValidBST(root.left, min, root.val) 
//             && isValidBST(root.right, root.val, max);
//     }
    
     //Solution 3
//          if(root == null)
//              return true;
//          Stack<TreeNode> stack = new Stack<>();
//          TreeNode curr = root;
//          TreeNode pre = null;
         
//          while(curr != null || !stack.isEmpty()) {
//              while(curr != null) {
//                  stack.push(curr);
//                  curr = curr.left;
//              }
             
//              curr = stack.pop();
//              if(pre != null && curr.val <= pre.val)
//                  return false;
//              pre = curr;
//              curr = curr.right;
//          }
//          return true;
         
         //Solution 4
         inorder(root);
         return isSorted();
     }
    
    List<Integer> list = new ArrayList<>();
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public boolean isSorted() {
        for(int i = 0; i < list.size() - 1; i++)
            if(list.get(i) >= list.get(i + 1))
               return false;
        return true;
    }
}
