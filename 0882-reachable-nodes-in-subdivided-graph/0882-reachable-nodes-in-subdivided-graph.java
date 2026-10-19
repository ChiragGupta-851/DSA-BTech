class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, cnt});
            adj.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[]{u, cnt});
        }
        
       
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
       
        pq.offer(new int[]{0, 0});
        dist[0] = 0;
        
        
        Map<String, Integer> usedEdgeDots = new HashMap<>();
        
        int totalReachableNodes = 0;
        
        // Phase 1: Standard Dijkstra to find shortest paths to major nodes
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentMoves = current[0];
            int u = current[1];
            
            
            if (currentMoves > dist[u]) {
                continue;
            }
            
            
            totalReachableNodes++;
            
            int movesRemaining = maxMoves - currentMoves;
            
            if (!adj.containsKey(u)) continue;
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int dots = neighbor[1];
                
                
                int dotsReached = Math.min(movesRemaining, dots);
                usedEdgeDots.put(u + "-" + v, dotsReached);
                
                int newMoves = currentMoves + dots + 1;
                if (newMoves <= maxMoves && newMoves < dist[v]) {
                    dist[v] = newMoves;
                    pq.offer(new int[]{newMoves, v});
                }
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int totalDotsOnEdge = edge[2];
            
            int dotsFromU = usedEdgeDots.getOrDefault(u + "-" + v, 0);
            int dotsFromV = usedEdgeDots.getOrDefault(v + "-" + u, 0);
            
            totalReachableNodes += Math.min(totalDotsOnEdge, dotsFromU + dotsFromV);
        }
        
        return totalReachableNodes;
    }
}