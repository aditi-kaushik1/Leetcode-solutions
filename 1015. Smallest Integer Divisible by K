/*Given a positive integer K, you need to find the length of the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.
Return the length of N. If there is no such N, return -1.
Note: N may not fit in a 64-bit signed integer. */


    class Solution {
    public int smallestRepunitDivByK(int K) {
        /* Using the pigeonhole priciple, which suggests that 
        if there are n objects and m containers, 
        where n > m, then atleast 1 container must contain more than 1 objects.
        Hence, the loop must go only 'k' times, since after that the remainders 
        start repeating and we would enter an infinite loop and if there exists an 'N', 
        then it would appear till then.*/
        //For multiples of 2 and 5, there won't be any 'N'
        if(K % 5 == 0 || K % 2 == 0 || K < 0)
            return -1;
        int remainder = 1;
        //In java, long has 64 bits and beyond that, 
        //there is no primitve data type to store info.
        //Hence, make use of remainders, as 'N' and remainder
        //will give the same remainder with K.
        /* N = p * K + remainder
        10N + 1 = (10 * p *K + 10) * remainder +1 
        Clearly remainder can be used in place of N. */
        for(int i = 0; i < K; i++){
            int N = (remainder * 10) + 1;
            if(remainder % K == 0)
                return (i + 1);
            //Change the value of remainder for each iteration
            remainder = N % K;
        }
        return -1;
    }
}
