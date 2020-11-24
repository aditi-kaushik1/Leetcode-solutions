/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         //Create a list of list for returning (similar to subsets question)
//         List<List<Integer>> result = new ArrayList();
//         //Corner case
//         if(root == null){
//             return result;
//         }
//         //Initialise a queue
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             //For every single level, make a list of all the values of nodes.
//             List<Integer> currentLevel = new ArrayList<>();
//             //Iterate through all things in queue.
//             for(int i = 0;i<size;i++){
//                 //Get the current node that we need to process
//                 TreeNode current = queue.remove();
//                 //Add it's value to currentLevel list
//                 currentLevel.add(current.val);
//                 //Check if the current node has a left or right child.
//                 //If it has either of those, then add it in queue.
//                 //Process them in subsequent iterations.
//                 if(current.left != null)
//                     queue.add(current.left);
//                 if(current.right != null)
//                     queue.add(current.right);
//             }
//             //Add currentLevel to the final lis of lists, result.
//             result.add(currentLevel);
//         }
//         return result;
//     }
// }   
     
public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		levelOrderHelper(res, root, 0);
		return res;
	}
	
	public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= res.size()) {
			curr = new ArrayList<>();
			curr.add(root.val);
			res.add(curr);
		} else {
			curr = res.get(level); 
			curr.add(root.val); 
			//res.add(curr); 
            // No need to add the curr into the res, because the res.get(index) method does              not remove the index element
		}
		levelOrderHelper(res, root.left, level + 1);
		levelOrderHelper(res, root.right, level + 1);
	}
 }
