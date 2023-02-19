class Solution {
    public int minMaxDifference(int num) {
        List<Integer> list = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        double large = 0;
        double small = 0;
        int x = num;
        while(x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int index = list.size() - 1;
        int mostSignificantBitLow = list.get(index);
        int mostSignificantBitHigh = list.get(index);
        while(mostSignificantBitHigh == 9 && index > 0) {
            index--;
            mostSignificantBitHigh = list.get(index);
        }
        if(index < 0)
            return num;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == mostSignificantBitLow) {
                low.add(0);
            }
            
            else {
                low.add(list.get(i));
            }
            if(list.get(i) == mostSignificantBitHigh) {
                high.add(9);
            }
            else
                high.add(list.get(i));
        }
        
        for(int i = 0; i < list.size(); i++) {
            large = large + Math.pow(10,i)*high.get(i);
            small = small + Math.pow(10,i)*low.get(i);
        }
        return (int)(large - small);
    }
}
