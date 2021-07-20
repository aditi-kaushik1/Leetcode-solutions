/* Count the number of prime numbers less than a non-negative number, n. */

class Solution {
    public int countPrimes(int n) {
        //Solution 1
        //Time limit exceeded
        //Brute force approach - O(n^(3/2)) time complexity
        // int count = 0;
        // for(int i = 2; i < n; i++) {
        //     boolean isPrime = true;
        //     for(int j = 2; j <= Math.pow(i, 0.5); j++)
        //         if(i % j == 0) {
        //             isPrime = false;
        //             continue;
        //         }
        //     if(isPrime)
        //         count++;
        // }
        // return count;
        
        //Solution 2
        //Reference video : https://www.youtube.com/watch?v=eKp56OLhoQs&t=1s
        //Sieve of Erastothenes
        //Time complexity - O(nlog(log(n)))
        
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(notPrime[i] == false) {
                for(int j = 2; j*i < n; j++)
                    notPrime[i*j] = true;
            }
        }
        
        for(int i = 2; i < n; i++) {
            if(!notPrime[i])
                count++;
        }
        return count;
    }
}
