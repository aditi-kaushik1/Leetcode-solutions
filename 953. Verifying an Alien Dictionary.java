class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 1; i <= order.length(); i++) {
            map.put(order.charAt(i - 1), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            int x = 0;
            int y = 0;
            String first = words[i];
            String second = words[i + 1];
            while(x < first.length() && y < second.length()) {
                if(map.get(first.charAt(x)) < map.get(second.charAt(y)))
                    break;
                else if(map.get(first.charAt(x)) > map.get(second.charAt(y)))
                    return false;
                x++;
                y++;
            }
            if(first.length() > second.length() && first.substring(0, second.length()).equals(second))
                return false;
        }
        return true;
    }
}
