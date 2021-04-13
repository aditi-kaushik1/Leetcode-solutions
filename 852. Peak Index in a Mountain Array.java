/* Let's call an array arr a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, 
return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]. */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //Solution 1
        //Linear scan
        // for(int i = 1; i < arr.length - 1; i++) {
        //     if(arr[i] > arr[i+1])
        //         return i;
        // }
        // return -1;
        
        //Binary search iterative
//         int left = 0;
//         int right = arr.length - 1;
//         int mid;
//         int res = -1;
        
//         while(left <= right) {
//             mid = left + (right - left)/2;
//             if(arr[mid] > arr[mid + 1]) {
//                 res = mid;
//                 right = mid - 1;
//             }
//             else if(arr[mid] < arr[mid + 1])
//                 left = mid + 1;
//         }
//         return res;
        
        //Binary search recursive
        return binarySearchRecursive(arr,0,arr.length - 1);
    }
    
    public int binarySearchRecursive(int[] arr, int left, int right) {
        int mid;
        int res = 0;
        mid = left + (right - left)/2;
        if(left == right)
            return left;
        if(arr[mid] > arr[mid + 1])
            return binarySearchRecursive(arr,left,mid);
        return binarySearchRecursive(arr,mid + 1, right);
    }
}
