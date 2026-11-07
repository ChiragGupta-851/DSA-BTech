class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int V = 26;
        long INF = 1L << 40; 
        long[][] dist = new long[V][V];
       
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        long totalCost = 0;
        int n = source.length();
        
        for (int i = 0; i < n; i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            
            if (dist[u][v] >= INF) {
                return -1;
            }
            
            totalCost += dist[u][v];
        }
        
        return totalCost;
    }
}