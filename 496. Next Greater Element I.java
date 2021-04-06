/*You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.*/


class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //https://www.youtube.com/watch?v=8BDKB2yuGyg
        //Algorithm
        /*Create a HashMap and store the value of next greater element 
        for each element in nums2, using for loop.
        Use a stack to store the order of numbers in it.
        Then in nums1, replace the elements with the 
        corresponding values from HashMap.*/
        
        //Create a HashMap and a stack.
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        //Run a for loop to find the next greatest element in nums2.
        for(int i=0;i<nums2.length;i++){
            //Always use !stack.isEmpty() before using stack.peek() or stack.pop().
            //Use while for cases where numbers constantly decrease 
            //and then finally increase.
            while(!stack.isEmpty() && stack.peek()<nums2[i])
                 map.put(stack.pop(),nums2[i]);
                 stack.push(nums2[i]);
            }
        
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}

//or (second attempt,same solution, revision)

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> stack = new Stack<>();
//         HashMap<Integer, Integer> ans = new HashMap<>();
//         for(int i = nums2.length - 1; i >= 0; i--) {
//             while(!stack.isEmpty() && stack.peek() <= nums2[i])
//                 stack.pop();
//             if(stack.isEmpty())
//                 ans.put(nums2[i],-1);
//             else
//                 ans.put(nums2[i],stack.peek());
//             stack.push(nums2[i]);
//         }
//         int[] x = new int[nums1.length];
//         for(int i = 0; i < nums1.length; i++) {
//             x[i] = ans.get(nums1[i]);
//         }
//         return x;
//     }
// }
