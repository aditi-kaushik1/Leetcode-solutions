/* Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn]. */


class Solution {
    public int[] shuffle(int[] nums, int n) {
        /*Solution 1*/
        // int[] newArr = new int[2*n];
        // int indexEven = 0;
        // int indexOdd = 0;
        // for(int i = 0; i < 2*n; i++){
        //     if(i % 2 == 0){
        //         newArr[i] = nums[indexEven];
        //         indexEven++;
        //     }
        //     else{
        //         newArr[i] = nums[n + indexOdd];
        //         indexOdd++;
        //     }
        // }
        // return newArr;
        
        /*Solution 2*/
        int[] newArr = new int[2 * n];
        int i = 0, j = 0;
        while(i < (2 * n)){
            if(i % 2 == 0)
                newArr[i] = nums[i/2];
            else
                newArr[i] = nums[n + i/2];
            i++;
        }
        return newArr;
    }
}
