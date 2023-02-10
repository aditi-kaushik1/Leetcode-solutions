class Solution {
    public long distinctNames(String[] ideas) {
        //Solution 1
        //Brute force
        //Satisfies 74/89 test cases only
        //Time complexity is O(n^2)
        // Set<String> set = new HashSet<>();
        // for(String str : ideas) {
        //     set.add(str);
        // }
        // int answer = 0;
        // for(int i = 0; i < ideas.length; i++) {
        //     for(int j = i + 1; j < ideas.length; j++) {
        //         if(ideas[i].charAt(0) == ideas[j].charAt(0))
        //             continue;
        //         String str1 = ideas[j].charAt(0) + ideas[i].substring(1);
        //         if(set.contains(str1))
        //             continue;
        //         String str2 = ideas[i].charAt(0) + ideas[j].substring(1);
        //         if(set.contains(str2))
        //             continue;
        //         answer += 2;
        //     }
        // }
        // return answer;

        //Solution 2
        /* Debug this code. Because of line 61, certain cases are getting counted twice and we are getting the wrong answer for half the cases. */
        // int n = ideas.length;
        // int numOfCombinations = (n*(n - 1))/2;
        // int[] startingAlphabet = new int[26];
        // Map<String, List<Character>> map = new HashMap<>();

        // for(String str : ideas) {
        //     char startsWith = str.charAt(0);
        //     startingAlphabet[startsWith - 'a']++;

        //     if(map.containsKey(str.substring(1))) {
        //         map.get(str.substring(1)).add(startsWith);
        //     }
        //     else {
        //         List<Character> list = new ArrayList<>();
        //         list.add(startsWith);
        //         map.put(str.substring(1), list);
        //     }
        // }

        // for(int i = 0; i < 26; i++) {
        //     if(startingAlphabet[i] > 1) {
        //         int sameAlphabetCombination = (startingAlphabet[i] * (startingAlphabet[i] - 1))/2;
        //         numOfCombinations = numOfCombinations - sameAlphabetCombination;
        //     }
        // }

        // for(Map.Entry<String, List<Character>> entry : map.entrySet()) {
        //     List<Character> list = entry.getValue();
        //     int len = list.size();
        //     if(len > 1) {
        //         int number = 0;
        //         for(int i = 0; i < len; i++) {
        //             number = number + (len - 1)*(startingAlphabet[list.get(i) - 'a'] - 1);
        //         }
        //         numOfCombinations -= number;
        //         int listCombination = (len * (len - 1))/2;
        //         numOfCombinations -= listCombination;
        //     }
        // }
        // return numOfCombinations*2;

        //Solution 3
        Map<Character, Set<String>> map = new HashMap<>();
        for(String str : ideas) {
            if(map.containsKey(str.charAt(0))) {
                map.get(str.charAt(0)).add(str.substring(1));
            }
            else {
                Set<String> set = new HashSet<>();
                set.add(str.substring(1));
                map.put(str.charAt(0), set);
            }
        }

        long answer = 0;
        for(Map.Entry<Character, Set<String>> entry : map.entrySet()) {
            for(Map.Entry<Character, Set<String>> entry1 : map.entrySet()) {
                if(entry.getKey() == entry1.getKey())
                    continue;
                int common = 0;
                for(String s : entry1.getValue()) {
                    if(entry.getValue().contains(s))
                        common++;
                }
                answer += (entry.getValue().size() - common) * (entry1.getValue().size() - common);
            }
        }
        return answer;

        /*
        ["coffee","donuts","time","toffee","tea","boffee","bee","crab"]
        C->  rab, offee
        D->onuts
        T->ime,offee,ea
        B->offee, ee
        */     
    }
}
