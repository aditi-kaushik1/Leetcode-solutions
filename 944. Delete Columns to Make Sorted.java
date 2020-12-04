/*We are given an array A of N lowercase letter strings, all of the same length.
Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], 
and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]]).
Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.
Return the minimum possible value of D.length.*/
/*This problem is esstentially asking how many columns are not in non-decreasing order.
The moment you find a column that is not in non-decreasing order, stop checking that column and move on to the rest of the array.
Originally, I thought the problem was looking for the minimum number of deleted items that would make every column remain in non-decreasing order. 
That would be an enitrely different problem. */

class Solution {
    public int minDeletionSize(String[] A) {
        /*Brute force approach is to write the 26 alphabets 
        to specify the order to the system.*/
        //But this will be very lengthy. Hence make use of ASCII values.
        
        //Algorithm:
        /*Find length of array and length of strings in array.
        Using loop, we need to compare the i'th element of each string element.
        Hence use nested loops.
        */
        int check = 0;
        //We have to consider a single column and then check for each string, 
        //and not vice versa.
        //Hence, in nested for loop, the loop for the columns will be the outer loop 
        //and the loop for the strings will be the inner loop.
        
        for(int j=0;j<A[0].length();j++)
        for(int i = 0;i<A.length-1;i++)
                if(A[i].charAt(j)>A[i+1].charAt(j)){
                check++;
                break;
                }
        return check;
    }
}
