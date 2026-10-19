class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
          Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        pq.offer(new int[]{0, src, 0});
        dist[src][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int u = current[1];
            int flightsUsed = current[2];
            
            // First time we pop 'dst', it's guaranteed to be the cheapest valid answer
            if (u == dst) {
                return currentCost;
            }
            
            // Optimization: If the popped cost is worse than what we already tracked 
            // for this exact flight count, skip it.
            if (currentCost > dist[u][flightsUsed]) {
                continue;
            }
            
            if (flightsUsed > k) {
                continue;
            }
            
            if (!adj.containsKey(u)) continue;
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int price = neighbor[1];
                
                int newCost = currentCost + price;
                int nextFlights = flightsUsed + 1;
                
                if (newCost < dist[v][nextFlights]) {
                    dist[v][nextFlights] = newCost;
                    pq.offer(new int[]{newCost, v, nextFlights});
                }
            }
        }
        
        return -1; 
    }
}