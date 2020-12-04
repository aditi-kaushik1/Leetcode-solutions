class Solution {
    public int singleNumber(int[] nums) {
        /*Solution 1*/
        /*XOR of two same numbers always gives 0, and XOR of a number with 0 gives the number itself.
        Hence, the XOR of all elements are taken at once.*/
        // int xor1=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     xor1=xor1^nums[i];
        // }
        // return xor1;
        
        /*Solution 2*/
        /*Brute force*/
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j] && i!=j)
        //             break;
        //         else if(j==(nums.length-1)){
        //             count=nums[i];
        //         }
        //     }
        // }
        // return count;
        
        /*Solution 3*/
        /*Use HashMap to store the element and it's count. 
        Check if the count is 1, then return that element.*/
        Integer count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                count = 2;
                map.put(nums[i],count);
            }
            else
            {
                count = 1;
                map.put(nums[i],count);
            }
        }
        int key = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
           int currentValue = e.getValue();
            if(currentValue == 1)
            {
                key = e.getKey();
                break;
            }
        }
        return key;
    }
}
