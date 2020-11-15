/*Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2^x.*/

class Solution {
    public boolean isPowerOfTwo(int n) {
            /*Solution 1*/
      // if(n==0){
      //     return false;
      // }
      //   else
      //       while(n%2==0)
      //       n/=2;
      //   return (n==1);
        
        /*Solution 2*/
        // if(n>0 && (n & (n-1))==0){
        //     return true;
        // }
        //    return false;
        
        /*Solution 3*/
        int count=0;
        if(n<0)
            return false;
        while(n!=0){
        if((n & 1) == 1)
            count++;
        n>>=1;
        }
        if(count==1)
                return true;
            else
                return false;
        
        /*Solution 4*/
        //return((n>0) && ((n & (n-1))==0));
    }
}
