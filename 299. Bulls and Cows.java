class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int bulls = 0;
        int cows = 0;
        
        for(char charOfSecret : secret.toCharArray()) {
            if(charOfSecret == guess.charAt(i++))
                bulls++;
            else {
                map.put(charOfSecret, map.getOrDefault(charOfSecret, 0) + 1);
            }
        }
        
        int j = 0;
        for(char charOfGuess : guess.toCharArray()) {
            if(charOfGuess != secret.charAt(j++)) {
                if(map.getOrDefault(charOfGuess, 0) > 0) {
                    cows++;
                    map.put(charOfGuess, map.get(charOfGuess) - 1);
                }
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
