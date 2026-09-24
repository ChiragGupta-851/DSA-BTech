class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); 
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adjList, visited);
    }
    
    private boolean dfs(int current, int destination, List<List<Integer>> adjList, boolean[] visited) {
        if (current == destination) return true;
        
        visited[current] = true;
        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, adjList, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}