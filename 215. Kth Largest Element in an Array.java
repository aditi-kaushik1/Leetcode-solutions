/* Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element. */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Solution 1
        //Time complexity : O(nlogn), space complexity : O(1)
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        
        //Solution 2
        //Time complexity : O(nlogk), space complexity : O(k)
        // PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        // for(int val : nums) {
        //     heap.add(val);
        //     if(heap.size() > k)
        //         heap.poll();
        // }
        // return heap.remove();
        
        //Solution 3
        //QuickSelect
        //Best and average time complexity : O(n), space complexity : O(1)
        //Worst case time complexity : O(n^2)
        return sort(nums, 0, nums.length - 1, k);
    }
    
    
    
    public int sort(int[] nums, int start, int end, int k) {
        if(start > end)
            return -1;
        if(start == end)
            return nums[start];
        int boundary = partition(nums, start, end);
        if(nums.length - boundary == k) {
            return nums[boundary];
        }
        else if(k > (nums.length - boundary))
            return sort(nums, start, boundary - 1, k);
        else
            return sort(nums, boundary + 1, end, k);
    }
    
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int boundary = start - 1;
        for(int i = start; i <= end; i++)
            if(nums[i] <= pivot)
                swap(nums, ++boundary, i);
        return boundary;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
