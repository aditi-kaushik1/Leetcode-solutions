/* Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:
Input: num = 0
Output: 0
 
Constraints:
0 <= num <= 231 - 1 */

class Solution {
    public int addDigits(int num) {
        //Solution 1
        /* Time complexity is always very less, even if the number is (2^31)- 1,
        suppose the number is 9999...8 times, then the inside loop will run 8 times,
        and the number will become 72, then the inside loop will run twice,
        and the number will become 9. Hence, time taken is very small 
        and independent of n. */
        
        // while(num / 10 != 0) {
        //     int x = num;
        //     int ans = 0;
        //     while(x != 0) {
        //         ans = ans + (x % 10);
        //         x /= 10;
        //     }
        //     num = ans;
        // }
        // return num;
        
        //Solution 2
        //Using divisibility of 9 property
        
        if(num == 0) return 0;
        else if(num % 9 == 0)  return 9;
        return (num % 9);
    }
}

/*Complexity Analysis
Time Complexity: \mathcal{O}(1)O(1).
Space Complexity: O(1)O(1).

Solution Page Leetcode :
Approach 1: Mathematical: Digital Root
Formula for the Digital Root

There is a known formula to compute a digital root in a decimal numeral system

dr_{10}(n) = 0, \qquad \text{if } n = 0dr 
10
​
 (n)=0,if n=0

dr_{10}(n) = 9, \qquad \text{if } n = 9 kdr 
10
​
 (n)=9,if n=9k

dr_{10}(n) = n \mod 9, \qquad \text{if } n \ne 9 kdr 
10
​
 (n)=nmod9,if n 

​
 =9k

How to derive it? Probably, you already know the following proof from school, where it was used for a divisibility by 9: "The original number is divisible by 9 if and only if the sum of its digits is divisible by 9". Let's revise it briefly.

The input number could be presented in a standard way, where d_0, d_1, .. d_kd 
0
​
 ,d 
1
​
 ,..d 
k
​
  are digits of n:

n = d_0 + d_1 \cdot 10^1 + d_2 \cdot 10^2 + ... + d_k \cdot 10^kn=d 
0
​
 +d 
1
​
 ⋅10 
1
 +d 
2
​
 ⋅10 
2
 +...+d 
k
​
 ⋅10 
k
 

One could expand each power of ten, using the following:

10 = 9 \cdot 1 + 1 \\ 100 = 99 + 1 = 9 \cdot 11 + 1 \\ 1000 = 999 + 1 = 9 \cdot 111 + 1 \\ ... \\ 10^k = 1\underbrace{00..0}_\text{k times} = \underbrace{99..9}_\text{k times} + 1 = 9 \cdot \underbrace{11..1}_\text{k times} + 110=9⋅1+1
100=99+1=9⋅11+1
1000=999+1=9⋅111+1
...
10 
k
 =1 
k times
00..0
​
 
​
 = 
k times
99..9
​
 
​
 +1=9⋅ 
k times
11..1
​
 
​
 +1

That results in

n = d_0 + d_1 \cdot (9 \cdot 1 + 1) + d_2 \cdot(9 \cdot 11 + 1) + ... + d_k \cdot (9 \cdot \underbrace{11..1}_\text{k times} + 1)n=d 
0
​
 +d 
1
​
 ⋅(9⋅1+1)+d 
2
​
 ⋅(9⋅11+1)+...+d 
k
​
 ⋅(9⋅ 
k times
11..1
​
 
​
 +1)

and could be simplified as

n = (d_0 + d_1 + d_2 + ... + d_k) + 9 \cdot (d_1 \cdot 1 + d_2 \cdot 11 + ... + d_k \cdot \underbrace{11..1}_\text{k times})n=(d 
0
​
 +d 
1
​
 +d 
2
​
 +...+d 
k
​
 )+9⋅(d 
1
​
 ⋅1+d 
2
​
 ⋅11+...+d 
k
​
 ⋅ 
k times
11..1
​
 
​
 )

The last step is to take the modulo from both sides:

n \mod 9 = (d_0 + d_1 + d_2 + ... + d_k) \mod 9nmod9=(d 
0
​
 +d 
1
​
 +d 
2
​
 +...+d 
k
​
 )mod9

and to consider separately three cases: the sum of digits is 0, the sum of digits is divisible by 9, and the sum of digits is not divisible by nine:

dr_{10}(n) = 0, \qquad \text{if } n = 0dr 
10
​
 (n)=0,if n=0

dr_{10}(n) = 9, \qquad \text{if } n = 9 kdr 
10
​
 (n)=9,if n=9k

dr_{10}(n) = n \mod 9, \qquad \text{if } n \ne 9 kdr 
10
​
 (n)=nmod9,if n 

​
 =9k
 
 though two last cases could be merged into one

dr_{10}(n) = 0, \qquad \text{if } n = 0dr 
10
​
 (n)=0,if n=0

dr_{10}(n) = 1 + (n - 1) \mod 9, \qquad \text{if } n \ne 0dr 
10
​
 (n)=1+(n−1)mod9,if n 

​
 =0 */
