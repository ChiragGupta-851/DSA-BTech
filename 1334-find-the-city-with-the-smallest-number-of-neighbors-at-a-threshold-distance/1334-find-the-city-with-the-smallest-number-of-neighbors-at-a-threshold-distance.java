class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) { //Floyd Warshall Algorithm
      int INF = 10_000_000; 
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; 
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        
        // Core Floyd-Warshall Algorithm (k must be the outermost loop)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int resultCity = -1;
        int minReachableCount = n; 
        
        for (int i = 0; i < n; i++) {
            int currentReachableCount = 0;
            
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    currentReachableCount++;
                }
            }
            
            if (currentReachableCount <= minReachableCount) {
                minReachableCount = currentReachableCount;
                resultCity = i;
            }
        }
        
        return resultCity;
    }  
    }
