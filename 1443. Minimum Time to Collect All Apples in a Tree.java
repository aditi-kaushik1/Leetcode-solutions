class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer> connectedToEdges = new ArrayList<>();
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            if(adjacencyList.containsKey(edges[i][0])) {
                adjacencyList.get(edges[i][0]).add(edges[i][1]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list. add(edges[i][1]);
                adjacencyList.put(edges[i][0], list);
            }
            if(adjacencyList.containsKey(edges[i][1]))
                adjacencyList.get(edges[i][1]).add(edges[i][0]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][0]);
                adjacencyList.put(edges[i][1], list);
            }
        }
        traverse(adjacencyList, 0, -1, hasApple);
        System.out.println(answer);
        if(treeHasAtleastOneApple == false)
            return 0;
        else
            return answer - 2;
    }
    int answer = 0;
    boolean subtreeHasApple = false;
    boolean treeHasAtleastOneApple = false;

    public boolean traverse(Map<Integer, List<Integer>> adjacencyList, int node, int parent, List<Boolean> hasApple){
        boolean subtreeHasApple = false;
        System.out.print(node + "->");
        List<Integer> list = adjacencyList.get(node);
        for(int i = 0; i < list.size(); i++) {
            int child = list.get(i);
            if(child == parent)
                continue;
            boolean responseFromChild = traverse(adjacencyList, child, node, hasApple);
            if(responseFromChild == true)
                subtreeHasApple = true;
        }
        if(hasApple.get(node) == true) {
            treeHasAtleastOneApple = true;
            subtreeHasApple = true;
        }
        if(subtreeHasApple == true) {
            answer += 2;
            return true;
        }
        else 
            return false;
    }
}

//0 -> 1,2
//1 -> 0,4,5
//2 -> 0,3,6
//3 -> 2
//4 -> 1
//5 -> 1
//6 -> 2
