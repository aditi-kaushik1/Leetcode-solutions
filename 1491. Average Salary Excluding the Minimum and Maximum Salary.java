/* You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000

Constraints:
3 <= salary.length <= 100
1000 <= salary[i] <= 106
All the integers of salary are unique. */

class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int sum = 0;
        
        for(int x : salary) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }
        
        sum = (sum - min - max);
        //return Math.round((sum/(salary.length - 2)*100000.0)/100000.0);
        return (double)sum/(double)(salary.length - 2); 
    }
}
