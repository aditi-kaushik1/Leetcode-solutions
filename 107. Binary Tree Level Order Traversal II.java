/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
] */


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*Reference question, code and video in: 102. Binary Tree Level Order Traversal*/
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);       
            }
            result.add(currentLevel);
    }
        /*Solution 1 to reverse, using additional space*/
        // List<List<Integer>> revArray = new ArrayList<>();
        // for(int i=result.size()-1;i>=0;i--){
        //     revArray.add(result.get(i));
        // }
        
        /*Solution 2 to reverse, without using additonal space*/
        // for(int i=0;i<result.size()/2;i++){
        //     List temp = result.get(i);
        //     result.set(i,result.get(result.size()-i-1));
        //     result.set(result.size()-1-i,temp);
        // }
        
        /*Solution 3 (Pre defines method) */
        Collections.reverse(result);
        return result;
}
}
