class Solution {
        private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int[] vis) {
        vis[node] = 1; 
        for (Integer neighbor : adjLs.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, adjLs, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V]; 
        int provinceCount = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                provinceCount++; 
                dfs(i, adjLs, vis); 
            }
        }
        
        return provinceCount;
    }
}