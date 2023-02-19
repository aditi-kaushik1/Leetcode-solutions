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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null)
            return ans;
        deque.addFirst(root);
        int level = 0;
        while(!deque.isEmpty()) {
            int length = deque.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                if(level % 2 == 0) {
                    TreeNode current = deque.removeFirst();
                    list.add(current.val);
                    if(current.left != null)
                        deque.addLast(current.left);
                    if(current.right != null)
                        deque.addLast(current.right);
                }
                else {
                    TreeNode current = deque.removeLast();
                    list.add(current.val);
                    if(current.right != null)
                        deque.addFirst(current.right);
                    if(current.left != null)
                        deque.addFirst(current.left);
                }
            }
            level++;
            ans.add(list);
        }
        return ans;
    }
}
