/* Given a non-empty array nums containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.*/

class Solution {
    public boolean canPartition(int[] nums) {
        //Solution 1
        /*Using memoization
        It is enhanced recursion. It involves recursive code and storage.
        For recursion code, we need choice diagram.
        We write base condition, followed by code for choice diagram.
        Then, we declare a matrix at the top, and initialise all cells by -1.
        After writing code for base condition, we check if t[n][S] != -1,
        then we return that value.
        Else we return t[n][S] = helperMethod(appropriate arguments).
        We make use of 2 methods in memoization.*/
        
//         int sum = 0;
//         for(int x : nums) {
//             sum += x;
//         }
//         if(sum % 2 == 1)
//             return false;
//         int n = nums.length;
//         int S = sum/2;
//         int[][] t = new int[n + 1][S + 1];
//         for(int i = 0; i < n+1; i++) {
//             for(int j = 0; j < S+1; j++) {
//                 t[i][j] = -1;
//             }
//         }
//         int ans = canPartitionHelper(nums,S,n,t);
//         return (ans == 1) ? true : false;
//     }
    
//     public int canPartitionHelper(int[] nums, int S, int n, int[][] t) {
//         if(n == 0 && S != 0)
//             return 0;
//         if(S == 0)
//             return 1;
//         if(t[n][S] != -1)
//             return t[n][S];
//         if(nums[n - 1] <= S)
//          return t[n][S] = Math.max(canPartitionHelper(nums,S - nums[n-1],n-1,t),
//                                   canPartitionHelper(nums,S,n-1,t));
//         else
//             return t[n][S] = canPartitionHelper(nums,S,n-1,t);
        
        //Solution 2
        /*Using tabular approach
        This is obtained from recursive solution.
        We change the recursive code to iterative code.
        Instead of calling the recursive function, we set the value of t[n][S].
        We declare a matrix and then initialise the first row and first column.
        Then we change the code of choice diagram to iterative code.
        Finally we return t[n][S].
        Remember to replace n and S with i and j.*/
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum % 2 != 0)
            return false;
        int S = sum/2;
        int n = nums.length;
        boolean[][] t = new boolean[n+1][S+1];
        for(int i = 0; i < n+1; i++)
            for(int j = 0; j < S+1; j++) {
                if(i == 0)
                  t[i][j] = false;
                if(j == 0)
                    t[i][j] = true;
            }
        for(int i = 1; i < n+1; i++)
            for(int j = 1; j < S+1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        return t[n][S];
    }
}
