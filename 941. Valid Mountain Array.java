/* Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1] */

class Solution {
    public boolean validMountainArray(int[] arr) {
        //Solution 1
        //O(n) solution
        //Too many if conditions used.
//         int n = arr.length;
//         int count = 0;
        
//         if(n < 3 || arr[0] > arr[1] || arr[n-1] > arr[n-2])
//             return false;
        
//         for(int i = 1; i < n - 1; i++) {
//             if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
//                 count++;
//             if(count > 1)
//                 return false;
//             if(arr[i] == arr[i+1])
//                 return false;
//         }
//         if(count == 0)
//             return false;
//         return true;
        
        //Solution 2
        //Leetcode solution page
        /* If two pointers are used starting from either end,
        then they must meet at the same point.
        Hence, i should be equal to j, provided i = 0 and j = n-1 initially.
        Also, we need to make sure that i = 0 or n-1 are not the peek.
        Hence check if i > 0 and j < n or not. 
        But unlike previous solution, it needs 2 iterations. */
        int n = arr.length;
        int i = 0;
        while(i < n - 1 && arr[i] < arr[i+1])
            i++;
        int j = n - 1;
        while(j > 0 && arr[j] < arr[j-1])
            j--;
        if(i == j && i > 0 && j < n - 1)
            return true;
        return false;
    }
}
