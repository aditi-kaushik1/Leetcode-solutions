/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Follow up: The overall run time complexity should be O(log (m+n)).*/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /* Use merge function of merge sort.
        * Use i and j index from leftmost side in both arrays.
        * Compare them, put the smaller number in a new array of size m + n.
        * One of the 2 arrays might get exhausted, 
          so after that put all the elements of other array in new array.
        * Find m + n
        * If it is odd, return (m + n + 1)/2 th term.
        * If it is even, return the average of (m + n)/2 th and ((m + n)/2 +1) th term.*/
        
        int i = 0;
        int j = 0;
        int k = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] numsFinal = new int[m + n];
        while( i < m && j < n){
            if(nums1[i] <= nums2[j]){
                numsFinal[k] = nums1[i];
                i++;
            }
            else{
                numsFinal[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            numsFinal[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            numsFinal[k] = nums2[j];
            j++;
            k++;
        }
        if((m + n) % 2 == 1){
            return numsFinal[((m + n + 1)/2) - 1];
        }
        else{
            return (float)(numsFinal[((m + n)/2) - 1] + numsFinal[((m + n)/2)])/2;
        }
    }
}
