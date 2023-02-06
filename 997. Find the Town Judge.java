class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> list;
        for(int i = 0; i < trust.length; i++) {
            if(map.containsKey(trust[i][0])) {
                map.get(trust[i][0]).add(trust[i][1]);
            }
            else {
                list = new ArrayList<>();
                list.add(trust[i][1]);
                map.put(trust[i][0], list);
            }
        }
        
        int countOfPeopleNotTrustingAnyone = 0;
        int probableJudge = -1;
        for(int i = 1; i <= n; i++) {
            if(!map.containsKey(i)) {
                probableJudge = i;
                countOfPeopleNotTrustingAnyone++;
            }
            if(countOfPeopleNotTrustingAnyone > 1)
                return -1;
        }
        if(countOfPeopleNotTrustingAnyone == 0)
            return -1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) 
            if(!entry.getValue().contains(probableJudge))
                return -1;

        return probableJudge;
    }
}
