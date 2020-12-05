/* You have a long flowerbed in which some of the plots are planted, and some are not. 
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule. */


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /* Algorithm
        Traverse through the array
        Find where element is 0 and it's previous and next elements are 0.
        If condition satisfied, then n--.
        In loop, if n = 0, break.
        If n = 0, return true (at last) */
        
        int len = flowerbed.length;
        if(n == 0)
                return true;
        if(len == 1)
            return (flowerbed[0] == 0);
        if(len >= 2 && flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n --;
        }
        for(int i = 1; i < len - 1; i++){
            if(n == 0)
                break;
            if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                n --;
                flowerbed[i] = 1;
        }
        if(n != 0 && flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0){
             n --;
             flowerbed[len - 1] = 1;
        }
    }
        
        return (n == 0);      
}
}
