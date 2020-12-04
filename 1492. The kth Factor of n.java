/* Given two positive integers n and k.
A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.

Example 1:
Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3. */


class Solution {
    public int kthFactor(int n, int k) {
        /*Solution 1*/
        //Creating a list for it 
        // List<Integer> factors = new ArrayList<>();
        // for(int i = 1; i <= n; i ++){
        //     if(n % i == 0)
        //         factors.add(i);
        // }
        // if(factors.size() < k)
        //     return -1;
        // return factors.get(k - 1);
        
        
        /*Solution 2*/
        //Not creating a list for it
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0)
                count++;
            if(count == k)
                return i;
        }
        return -1;
    }
}
