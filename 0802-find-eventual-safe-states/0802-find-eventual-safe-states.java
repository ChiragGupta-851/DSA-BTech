class Solution {
     private boolean checkCycleDFS(int node, int[][] graph, boolean[] vis, boolean[] pathVis, int[] check) {
        vis[node] = true;
        pathVis[node] = true; 
        
        for (int neighbor : graph[node]) {
            if (!vis[neighbor]) {
                if (checkCycleDFS(neighbor, graph, vis, pathVis, check)) {
                    return true; 
                }
            } 
            else if (pathVis[neighbor]) {
                return true;
            }
        }
        pathVis[node] = false; 
        check[node] = 1;    
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                checkCycleDFS(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}