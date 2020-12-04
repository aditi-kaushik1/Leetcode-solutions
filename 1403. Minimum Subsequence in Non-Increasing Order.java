/*Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 
If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, 
return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 
Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.*/

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        //Sort the array in decreasing order : Sort in increasing order and then reverse
        //Find the sum of all elements
        /*Check if the sum of first n elements is greater than the    
        (total sum of all elements-sum of first n elements)*/
        //Return the elements in the form of a list if the above statement is true.
        
        /*Solution 1*/
       //  Arrays.sort(nums);
       //  List<Integer> list = new ArrayList<Integer>();
       //  int len=nums.length;
       //  int[] arr = new int[len];
       //  int sum = 0;
       //  for(int i=0;i<len;i++){
       //      arr[i] = nums[len-i-1];
       //      sum+=arr[i];
       //  }
       //  int x = arr[0];
       //  if(x>(sum-x)){
       //      list.add(x);
       //      return list;
       //  }
       //  int[] arr1=new int[len];
       //  for(int i=0;i<len;i++){
       //      arr1[i]=arr[i];
       //  }
       //  for(int i=1;i<len;i++){
       //      arr[i]+=arr[i-1];
       //      x=arr[i];
       //      if(x>(sum-x)){
       //          for(int j=0;j<=i;j++){
       //              list.add(arr1[j]);
       //          }
       //          return list;
       //      }
       //  }
       // return list; 
        
        /*Solution 2*/
        //Does the same thing as solution 1, but is only shorter
        //and does the work using a single array.
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int sum1 = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int j=nums.length-1;j>=0;j--){
            sum1 += nums[j];
            list.add(nums[j]);
            sum-=nums[j];
            if(sum1>sum)
                return list;
        }
        return list;
    }
}
