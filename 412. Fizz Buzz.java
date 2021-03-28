/* Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”. */

class Solution {
    public List<String> fizzBuzz(int n) {
        //Solution 1
        //Solution link : https://youtu.be/QPZ0pIK_wsc
        // ArrayList<String> ans = new ArrayList<>();
        // for(int i = 1; i <= n; i++) {
        //     var output = "";
        //     if(i % 3 == 0)
        //         output += "Fizz";
        //     if(i % 5 == 0)
        //         output += "Buzz";
        //     if(output == "")
        //         output += i;
        //     ans.add(output);
        // }
        // return ans;
        
        //Solution 2
        //When cases are too many, it's not possible to write a
        //seperate if condition for each case.
        List<String> output = new ArrayList<>();
       HashMap<Integer, String> map = new HashMap<>() {
           {
               put(3,"Fizz");
               put(5,"Buzz");
           }
       };
        for(int num = 1; num <= n;num++) {
            String ans = "";
            for(Integer x :map.keySet()) {
                if(num % x == 0)
                    ans += map.get(x);
            }
            if(ans == "")
                ans += num;
            output.add(ans);
        }
        return output;
    }
}
