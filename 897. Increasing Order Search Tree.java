/* Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
and every node has no left child and only one right child. */


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
    /*Solution 1*/
    //Do inorder traversal and save the values in a list
    //Make a new tree with left children as null(by default) and right children as elements of list.
    
    // public TreeNode increasingBST(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     inorder(root, list);
    //     //Pass 0 so that the root doesn't remain null.
    //     TreeNode ans = new TreeNode(0);
    //     //Create this to form the new tree.
    //     TreeNode curr = ans;
    // // Use for each loop to iterate over the list
    //     for(int v : list){
    //         curr.right = new TreeNode(v);
    //         curr = curr.right;
    //     }
    //     //Root has value 0, hence use ans.right.
    //     return ans.right;
    // }
    // public void inorder(TreeNode node, List<Integer> list){
    //     if(node == null)
    //         return;
    //     inorder(node.left , list);
    //     list.add(node.val);
    //     inorder(node.right , list);
    // }
    
    
    /*Solution 2*/
    // Similar to first solution, but in this, while doing inorder traversal,
    // we keeep creating the new Tree.
    
    //curr is declared as a global variable, since it is used in both methods.
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }
    public void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        //Every next node is null, hence node.left = null
        node.left = null;
        curr.right = node;
        curr = node;    // curr = curr.right = node;
        inorder(node.right);
    }
}
