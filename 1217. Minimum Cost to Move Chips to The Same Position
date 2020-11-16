/*We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.*/

class Solution {
    public int minCostToMoveChips(int[] position) {
        //Check out the solution section!
        int even_cnt = 0;
        int odd_cnt = 0;
        int cost;
        for(int num : position){
            if(num%2==0)
                even_cnt++;
            else
                odd_cnt++;    
        }
        return cost=Math.min(odd_cnt,even_cnt);
    }
}
