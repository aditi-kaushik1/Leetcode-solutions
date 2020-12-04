/*Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. 
Notice that multiple kids can have the greatest number of candies.*/


class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       
        //Declare an ArrayList containing Boolean values.
        List<Boolean> list = new ArrayList<Boolean>();
        int max1=0;
        //Find the highest element in array using for loop.
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max1)
                max1 = candies[i];
        }
        for(int i=0;i<candies.length;i++){
            //Using for loop, add the extra candies to each element
            if(candies[i]+extraCandies >= max1)
                list.add(true);
            //Check if it is >= max element.
            //Append true to the list, else append false.
            else
                list.add(false);
        }
        return list;
    }
}
