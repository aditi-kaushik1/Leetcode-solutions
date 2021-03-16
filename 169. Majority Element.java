/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.*/

class Solution {
    public int majorityElement(int[] nums) {
       /*Solution 1*/
        //Arrays.sort(nums);
        //return nums[nums.length/2];
        
        
        /*Solution 2*/
        /*https://www.geeksforgeeks.org/majority-element/ */
        /* https://www.youtube.com/watch?v=n5QY3x_GNDg&feature=youtu.be */
        /*Algorithm: 
        *Loop through each element and maintain a count of majority element, 
        and a majority index, maj_index
        *If the next element is same, then increment the count. If the 
        next element is not same then decrement the count.
        *If the count reaches 0 then change the maj_index 
        to the current element and set the count again to 1.
        *Now again traverse through the array and 
        find the count of majority element found.
        *If the count is greater than half the 
        size of the array, print the element
        *Else print that there is no majority element */
        int count = 0;
        Integer candidate = null;
        for(int num : nums){
            if(count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
        /*Since it is given that the majority element always exists,
        hence it is not necessary to verify that the candidate element 
        is the majority element or not.*/
        
        //or
        
        // int count = 1;
        // int majorityElementCandidate = nums[0];
        // for(int i = 1; i < nums.length; i++) {
        //     if(nums[i] == majorityElementCandidate)
        //         count++;
        //     else
        //         count--;
        //     if(count == 0) {
        //         majorityElementCandidate = nums[i];
        //         count = 1;
        //     }
        // }
        // return majorityElementCandidate; 
        
        /*Solution 3*/
        /*HashMap used*/
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue() > (nums.length/2))
        //         return entry.getKey();
        // }
        // return -1;
        
        //or
        
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(map.containsKey(nums[i]))
        //         map.put(nums[i], map.get(nums[i]) + 1);
        //     else
        //         map.put(nums[i],1);
        //     if(map.get(nums[i]) > nums.length/2)
        //         return nums[i];
        // }
        // return -1;
        
        //Solution 4
        //Nested for loop used
        //Time limit exceeded, for large array
        // if(nums.length == 1)
        //     return nums[0];
        // for(int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for(int j = i; j < nums.length; j++) {
        //         if(nums[i] == nums[j])
        //             count++;
        //         System.out.println(count);
        //     }
        //     if(count > nums.length/2)
        //         return nums[i];
        // }
        // return -1;
    }
}
