/* The array-form of an integer num is an array representing its digits in left to right order.
For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k. 

Constraints:
1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104*/

class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        //Solution 1
        //Contains duplication in both loops
        
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int sum = nums[i] + (k % 10) + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        while(k != 0) {
            int sum = carry + k % 10;
            list.add(0, sum % 10);
            carry = sum/10;
            k /= 10;
        }
        
        if(carry != 0)
            list.add(0, carry);
        
        return list;
    }
}
