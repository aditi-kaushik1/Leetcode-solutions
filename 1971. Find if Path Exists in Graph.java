class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1 && source == 0 && destination == 0)
            return true;
        else if(n == 1)
            return false;
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            if(adjacencyList.containsKey(edges[i][0])) {
                adjacencyList.get(edges[i][0]).add(edges[i][1]);
            }
            else {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(edges[i][1]);
                adjacencyList.put(edges[i][0], currentList);
            }

            if(adjacencyList.containsKey(edges[i][1])) {
                adjacencyList.get(edges[i][1]).add(edges[i][0]);
            }
            else {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(edges[i][0]);
                adjacencyList.put(edges[i][1], currentList);
            }
        }
        boolean[] visited = new boolean[n];
        return traverse(adjacencyList, source, destination, -1, visited);
    }
    boolean ans = false;

    public boolean traverse(Map<Integer, List<Integer>> adjacencyList, int source, int destination, int parent, boolean[] visited) {
        visited[source] = true;
        List<Integer> list = adjacencyList.get(source);
        if(list == null)
            return false;
        for(int i = 0; i < list.size(); i++) {
            int child = list.get(i);
            if(list.contains(destination)) {
                ans = true;
                break;
            }
            if(visited[child] == true)
                continue;
            if(child == parent)
                continue;
            traverse(adjacencyList, child, destination, source, visited);
        }
        return ans;
    }
}
