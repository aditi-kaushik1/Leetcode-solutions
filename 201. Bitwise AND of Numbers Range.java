/*Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive. */

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /*Solution 1*/
        /*did not run because of time complexity*/
        // int ans=m;
        // for(int i=m+1;i<=n;i++){
        //     ans&=i;
        // }
        // return ans;
        
        /*Solution 2*/
        /*refer this video for this solution!*/
        /*https://www.youtube.com/watch?v=-qrpJykY2gE*/
        int count=0;
        while(m!=n){
            count++;
            m>>=1;
            n>>=1;
        }
        return m<<count;
}
}
