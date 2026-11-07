class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
       int n = patience.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        dist[0] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int neighbor : adj.get(curr)) {
                if (dist[neighbor] == -1) { 
                    dist[neighbor] = dist[curr] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        int maxIdleTime = 0;
        
        for (int i = 1; i < n; i++) {
            int roundTrip = 2 * dist[i];
            int p = patience[i];
            
            int lastSent = ((roundTrip - 1) / p) * p;
            
            int serverIdleAt = lastSent + roundTrip + 1;
            
            maxIdleTime = Math.max(maxIdleTime, serverIdleAt);
        }
        
        return maxIdleTime; 
    }
}