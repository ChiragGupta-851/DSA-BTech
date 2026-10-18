class Solution {
    public int networkDelayTime(int[][] times, int n, int k) { //Dijkstra's Algorithm
        Map<Integer,List <int[]>> graph = new HashMap<>();
        for(int i = 0;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentTime = current[1];
            if (currentTime > dist[u]) continue;
            for (int[] neighbor : graph.get(u)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int nextTime = currentTime + weight;

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new int[]{nextNode, nextTime});
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
    }
     maxTime = Math.max(maxTime, dist[i]);
    
}
    return maxTime;

}
       
    }
