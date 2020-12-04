/*Reverse bits of a given 32 bits unsigned integer.
Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type.
They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. 
Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
Follow up:
If this function is called many times, how would you optimize it?*/


public class Solution {
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        /*Solution 1*/
        int num=0;
        //Run the loop 32 times starting from MSB. Right shift the MSB by "i" times
        //Hence in the first iteration, the MSB comes at the 1's position.
        //Use bit operations in place of pow(2,x), because it is faster.
        for(int i=31;i>=0;i--){
            num+=((n>>i)&1)<<(31-i);
        }
        return num;
        
        /*Solution 2*/
        //Stores the value of answer
        // int ans = 0;
        // //Since 32 bits are there, hence the loop runs 32 times.
        // for(int i=0;i<32;i++){
        //     //Left shift the answer, to reverse it.
        //     //In the first iteration, ans is still 0, 
        //     //but after that, it gets changed in every iteration.
        //     ans <<= 1;
        //     //n&1 helps to know the bit at LSB
        //     //ans now keeps track of the previously stored values in ans to..
        //     ans |= (n&1);
        //     //Right shift n to get the value of bit to the right of LSB.
        //     n >>= 1;
        // }
        // return ans;
}
}
