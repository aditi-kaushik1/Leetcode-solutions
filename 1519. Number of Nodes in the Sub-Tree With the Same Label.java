class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer> connectedVertices = new ArrayList<>();
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            if(adjacencyList.containsKey(edges[i][0])) {
                adjacencyList.get(edges[i][0]).add(edges[i][1]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                adjacencyList.put(edges[i][0], list);
            }

            if(adjacencyList.containsKey(edges[i][1])) {
                adjacencyList.get(edges[i][1]).add(edges[i][0]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][0]);
                adjacencyList.put(edges[i][1], list);
            }
        }
        ans = new int[n];
        traverse(labels, 0, adjacencyList, -1);
        return ans;
    }

    int[] ans;
    public Map<Character, Integer> traverse(String labels, Integer node, Map<Integer, List<Integer>> adjacencyList, int parent) {
        Map<Character, Integer> map = new HashMap<>();

        List<Integer> listOfConnectedNodes = adjacencyList.get(node);
        for(int i = 0; i < listOfConnectedNodes.size(); i++) {
            int child = listOfConnectedNodes.get(i);
            if(child == parent)
                continue;
            Map<Character, Integer> childMap = traverse(labels, child, adjacencyList, node);
            for (Map.Entry<Character, Integer> entry : childMap.entrySet()) {
                if(map.containsKey(entry.getKey()))
                    map.put(entry.getKey(), entry.getValue() + map.get(entry.getKey()));
                else
                    map.put(entry.getKey(), entry.getValue());
            }
        }
        char currentNodeLetter = labels.charAt(node);
        if(map.containsKey(currentNodeLetter)) {
            map.put(currentNodeLetter, map.get(currentNodeLetter) + 1);
        }
        else
            map.put(currentNodeLetter, 1);
        ans[node] = map.get(currentNodeLetter);
        return map;
    }
}

/*
0 -> 1,2
1 -> 0,4,5
2 -> 0,3,6
3 -> 2
4 -> 1
5 -> 1
6 -> 2
*/
