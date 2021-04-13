/* (This problem is an interactive problem.)
You may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  
Also, any solutions that attempt to circumvent the judge will result in disqualification. */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    /* Algorithm:
    Find the peak element. To it's left, it has ascending order.
    To it's right, it has desecnding order.
    Call 2 binary search functions, to it's left and right
    and search the element.
    Return -1 if -1 is returned from both the binary search methods.
    Also, this question is very particular about the space and time you use.
    So, since we know that the peak will always exist,
    we can initialise left = 0, right = array.length - 1
    and then use while(left < right).
    Because as soon as left == right, we have reached the solution, 
    and do not need to run any further iterations. 
    If you are confused with the interface, just write arr[mid] wherever needed,
    and in the end, replace it with mountainArr.get(mid).*/
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        int mid;
        int res = -1;
        while(left < right) {
            mid = left + (right-left)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1)) {
                res = mid;
                right = mid - 1;
            }
            if(mountainArr.get(mid) < mountainArr.get(mid+1))
                left = mid + 1;
        }
        
        int x = bsAscending(mountainArr, target, 0, res - 1);
        int y = bsDescending(mountainArr, target, res, n-1);
        if(x == -1 || y == -1)
            return Math.max(x,y);
        else
            return Math.min(x,y);
    }
    
    public int bsAscending(
        MountainArray mountainArr, int target, int left, int right) {
        int mid;
        while(left <= right) {
        mid = left + (right - left)/2;
        if(mountainArr.get(mid) == target)
            return mid;
        else if(target < mountainArr.get(mid))
            right = mid - 1;
        else
            left = mid+1;
        }
        return -1;
    }
    
    public int bsDescending(MountainArray mountainArr, int target, int left,int right) {
        int mid;
        while(left <= right) {
        mid = left + (right - left)/2;
        if(mountainArr.get(mid) == target)
            return mid;
        else if(target < mountainArr.get(mid))
            left = mid+1;
        else
            right = mid-1;
        }
        return -1;
    }
}
