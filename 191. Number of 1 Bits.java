/*Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*Solution 1*/
        // int count=0;
        // for(int i=0;i<32;i++){
        //     if((n & 1) == 1)
        //         count++;
        //     n>>=1;
        // }
        // return count;
        
        /*Solution 2*/
        // int count=0;
        // while(n!=0){
        //    count += n & 1;
        //     n>>=1;
        // }
        // return count;
        
        /*Solution 3*/
        // int count = 0;
        // for(int i=0; i<32; i++){
        //     count +=  n&1;
        //     n = n>>1;
        // }
        // return count;
        
        /*Solution 4*/
        /*Use >>> (triple right shift button) because it will put a 0 at the MSB while shifting, thus helping to get the correct answer. */
        // int count=0;
        // while(n!=0){
        //     if((n & 1) == 1)
        //         count++;
        //     n>>>=1;
        // }
        // return count;
        
        /*Solution 5*/
        /*Java ends up having issues when unsigned integers have to be used!
        Coz java doesn't have unsigned integer.
        One way to solve the problem is to use >>>. */
        int count = 0;
        
        while(n!=0){
            if(n%2==1)
                count++;
            n/=2;
        }
        return count;
        
        /*Solution 6*/
        // int count=0;
        // while(n!=0){
        //     n&=(n-1);
        //     count++;
        // }
        // return count;
    }
}
