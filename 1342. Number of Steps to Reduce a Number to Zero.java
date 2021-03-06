/*Given a non-negative integer num, return the number of steps to reduce it to zero. 
If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.*/

 
 class Solution {
    public int numberOfSteps (int num) {
        /*Solution 1*/
        /*Basic operations used*/
        // int count=0;
        // while(num!=0){
        //     if(num%2==0){
        //         num/=2;
        //     }
        //     else{
        //         num-=1;
        //     }
        //     count++;
        // }
        // return count;
        
        /*Solution 2*/
        /*Right shift operation used*/
        int count=0;
        while(num!=0){
            if(num%2==1)
                num-=1;
            else
            {num>>=1;}
           count++;
        }
        return count;
    }
}
