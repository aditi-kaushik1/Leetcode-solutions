// /* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value. */

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         // if(p == null && q == null)
//         //     return true;
//         // if(p == null || q == null)
//         //     return false;
//         // if(p.val != q.val)
//         //     return false;
//         // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
//         if(!check(p,q))
//             return false;
//         Queue<TreeNode> q1 = new LinkedList<>();
//         Queue<TreeNode> q2 = new LinkedList<>();
//         q1.add(p);
//         q2.add(q);
//         while(!q1.isEmpty() && !q2.isEmpty()) {
//             TreeNode temp1 = q1.remove();
//             TreeNode temp2 = q2.remove();
//             if(!check(temp1, temp2))
//                 return false;
//             if(temp1 != null) {
//                 q1.add(temp1.left);
//                 q1.add(temp1.right);
//             }
//             if(temp2 != null) {
//                 q2.add(temp2.left);
//                 q2.add(temp2.right);
//             }
//         }
//         return true;
//     }
    
//     public boolean check(TreeNode p, TreeNode q) {
//         if(p == null && q == null)
//             return true;
//         if(p == null || q == null)
//             return false;
//         return p.val == q.val;
//     }
// }


//Solution 3

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p == null && q == null)
        //     return true;
        // if((p == null && q !=null) || (p != null && q == null) || (p.val != q.val))
        //     return false;

        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(p == null && q == null)
            return true;

        int a = 0;
        
        if(p == null || q == null)
            return false;

        stack1.push(p);
        stack2.push(q);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if((stack1.peek() == null && stack2.peek() != null) || (stack1.peek() != null && stack2.peek() == null) || (stack1.peek().val != stack2.peek().val))
                return false;

            while(stack1.peek().left != null && stack2.peek().left != null) {
                stack1.push(stack1.peek().left);
                stack2.push(stack2.peek().left);
                if(stack1.peek().val != stack2.peek().val) {
                    return false;
                }
            }

            if((stack1.peek().left == null && stack2.peek().left != null) || (stack1.peek().left != null && stack2.peek().left == null))
                return false;

            if(stack1.isEmpty() && stack2.isEmpty())
                return true;

            if(stack1.isEmpty() || stack2.isEmpty())
                return false;

            while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().right == null && stack2.peek().right == null) {
                stack1.pop();
                stack2.pop();
            }

            if(stack1.isEmpty() && stack2.isEmpty())
                return true;

            if(stack1.isEmpty() || stack2.isEmpty())
                return false;

            if((stack1.peek().right == null && stack2.peek().right != null) || (stack1.peek().right != null && stack2.peek().right == null))
                return false;

            stack1.push(stack1.pop().right);
            stack2.push(stack2.pop().right);
        }
        return true;
    }
}
