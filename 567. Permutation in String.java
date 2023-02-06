class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> letterOccurencesIns1 = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            letterOccurencesIns1.put(ch, letterOccurencesIns1.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> currentMap = new HashMap<>();

        while(start <= end && end < s2.length()) {
            char current = s2.charAt(end);
            
            if(!letterOccurencesIns1.containsKey(current)) {
                end++;
                start = end;
                currentMap.clear();
            }

            else if(currentMap.containsKey(current) && currentMap.get(current) >= letterOccurencesIns1.get(current)) {
                while(s2.charAt(start) != current) {
                    currentMap.put(s2.charAt(start), currentMap.get(s2.charAt(start)) - 1);
                    start++;
                }
                currentMap.put(s2.charAt(start), currentMap.get(s2.charAt(start)) - 1);
                start++;
            }

            else {
                currentMap.put(current, currentMap.getOrDefault(current, 0) + 1);
                end++;
            }

            if((end - start) == s1.length())
                return true;
        }
        return false;
    }
}
