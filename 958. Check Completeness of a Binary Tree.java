/* Given the root of a binary tree, determine if it is a complete binary tree.
In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
Constraints:
The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000 */

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
    public boolean isCompleteTree(TreeNode root) {
        //Solution 1
        //Check Nick White video on youtube
        // Queue<TreeNode> q = new LinkedList<>();
        // boolean end = false;
        // q.add(root);
        // while(!q.isEmpty()) {
        //     TreeNode temp = q.remove();
        //     if(temp == null)
        //         end = true;
        //     else {
        //         if(end)
        //             return false;
        //         q.add(temp.left);
        //         q.add(temp.right);
        //     }
        // }
        // return true;
        
        //Solution 2
        //https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC%2B%2BPython-BFS-Solution-and-DFS-Soluiton
        
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // while(q.peek() != null) {
        //     TreeNode temp = q.remove();
        //     if(temp.left == null && temp.right != null)
        //         return false;
        //     q.add(temp.left);
        //     q.add(temp.right);
        // }
        // while(!q.isEmpty() && q.peek() == null)
        //     q.remove();
        // return q.isEmpty();
        
        //Solution 3
        //Recursive DFS approach
        //https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205675/Easy-recursive-solution-java
        
        int size = countNodes(root);
        return isCompleteTreeHelper(root, 0, size);
    }
    
    public boolean isCompleteTreeHelper(TreeNode root, int index, int size) {
        if(root == null)
            return true;
        if(index >= size)
            return false;
        return isCompleteTreeHelper(root.left, 2 * index + 1, size) &&
            isCompleteTreeHelper(root.right, 2 * index + 2, size);
    }
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

//Incomplete solution(extremely lengthy) :

//class Solution {
    //public boolean isCompleteTree(TreeNode root) {
        /* Conditions to be satisfied :
        ->Tree must be balanced.
        ->Size of tree should be atleast 2^h.
        ->If a node has a right child, it must have a left child.
        ->It will have anywhere between 1 to 2^h nodes at height h.
        ->In last level, if in level order traversal, we encounter null, 
          we must not encounter a non null node after that.
        */
 /*       
        if(!isBalanced(root))
            return false;
        if(!minSizeCriteria(root))
            return false;
        if(!rightChildButNoLeftChild(root))
            return false;
        if(!lastLevelSatisfies(root))
            return true;
        return true;
    }
    
    public boolean lastLevelSatisfies(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = height(root);
        while(!q.isEmpty()) {
            int size = q.size();
            if(size < Math.pow(2, height(root) - 1)) {
                while(size-- != 0) {
                    TreeNode temp = q.remove();
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            else {
                int size = q.size();
                while(size-- != 0) {
                    TreeNode temp = q.remove();
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
        }
    }
    
    public boolean rightChildButNoLeftChild(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right != null)
            return false;
    return rightChildButNoLeftChild(root.left) && rightChildButNoLeftChild(root.right);
    }
    
    public boolean minSizeCriteria(TreeNode root) {   
        int heightOfTree = height(root);
        return size(root) >= Math.pow(2,heightOfTree);
    }
    
    public int size(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
*/
