/*All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //Solution 1
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 9; i++) {
            String x = s.substring(i, i + 10);
            map.put(x, map.getOrDefault(x, 0) + 1);
            
            if(map.containsKey(x) && map.get(x) > 1 && !list.contains(x))
                list.add(x);
        }
        return list;
        
        //Lengthy way to write the same code
        //Algorithm used:
        /* Use a HashMap to store the substrings of length 10, 
        and increment the value of their key.
        Append those substrings in a list which have their value >= 2.*/
        
        //Create HashList
       // HashMap<String, Integer> map1 = new HashMap<>();
        //Create ArrayList
        //List<String> output = new ArrayList<String>();
        //Corner case where the string can't repeat
        //if(s.length()<11){
        //    return output;
        //}
        //for loop to traverse the string and get sbstrings
        //for(int i=0;i<s.length() - 9; i++){
          //  String substr = s.substring(i,i+10);
            //Check if the substring already exists
            //if(map1.containsKey(substr)){
              //  int a = map1.get(substr);
                //a++;
                //Increment it's value in HashMap
                //map1.replace(substr,a);
            //}
            //If the substring is not present, add it.
            // else{
              //  map1.put(substr,1);                                    
            }                               
        }
          
        //For-each loop to traverse through the HashMap
        for (Map.Entry mapElement : map1.entrySet()) { 
            //Add those entries to the list which have theirvalue>1
            //Use type conversion of "int" for getValue().
                if((int)mapElement.getValue() > 1) 
                    //Use type conversion of "string" type for getKey().
                    output.add((String)mapElement.getKey());
        } 
    
        return output;
    }
}
