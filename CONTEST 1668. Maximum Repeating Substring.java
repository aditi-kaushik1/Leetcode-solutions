/*For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. 
The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. 
If word is not a substring of sequence, word's maximum k-repeating value is 0.

Given strings sequence and word, return the maximum k-repeating value of word in sequence.*/


class Solution {
    public int maxRepeating(String sequence, String word) {
        
        /*Brute force*/
        // int add = 1;
        // while(sequence.contains(word.repeat(add)))
        //     add++;
        // return add - 1;
        
        /*Solution 2*/
        //Find length of string
        //Find length of substring
        int n = sequence.length();
        int len = word.length();
        int count = 0;
        int max = 0;
        //Run nested for loop till length of these
        for(int  i = 0 ; i < n - len + 1 ; i ++){
            count = 0;
            //Find it's first occurence
            if(word.equals(sequence.substring(i, i + len)))
                count ++;
            int index = i + len;
            //Check the number of times it repeats
    while((index < (n - len + 1)) && word.equals(sequence.substring(index, index + len))){
                    //Count the number of it's occurence
                    count++;
                    index += len;
}
            if(max < count)
                max = count;
        }
        return max;
    }
}            
