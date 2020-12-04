/*We have a collection of stones, each stone has a positive integer weight.
Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)*/

class Solution {
    public int lastStoneWeight(int[] stones) {
       //Sort the array in increasing order.
        //Use a for loop decrementing the counter from arr.length-1 to 0.
        //If arr[max]!=arr[max-1], arr[max-1] = arr[max] - arr[max-1];
        //Else, arr[max-1] = 0;
        //arr[max] = 0;
        //Sort the array again
        //return arr[max].
        
        //Solution 1
        Arrays.sort(stones);
        int max = stones.length-1;
        for(int i=max;i>0;i--){
            if(stones[max] != stones[max-1])
                stones[max-1] = stones[max] - stones[max-1];
            else
                stones[max-1] = 0;
            stones[max] = 0;
            Arrays.sort(stones);
        }
        return stones[max];
    }
}
