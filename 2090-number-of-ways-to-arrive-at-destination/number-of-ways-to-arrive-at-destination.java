class NodePair {
    long dist; 
    int node; 
    NodePair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<NodePair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        int m = roads.length;
        for(int i = 0; i < m; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            long w = roads[i][2];
            adj.get(u).add(new NodePair(w, v));
            adj.get(v).add(new NodePair(w, u)); 
        }
        PriorityQueue<NodePair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
        
        long[] dist = new long[n];
        int[] ways = new int[n]; 
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new NodePair(0, 0));
        
        int mod = (int)(1e9 + 7);
        
        while(!pq.isEmpty()){
            long dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            
            if (dis > dist[node]) continue;
            
            for(NodePair it : adj.get(node)){
                int adjnode = it.node;
                long edw = it.dist;
                
                if(dis + edw < dist[adjnode]){
                    dist[adjnode] = dis + edw;
                    pq.add(new NodePair(dis + edw, adjnode));
                    ways[adjnode] = ways[node];
                }
                else if(dis + edw == dist[adjnode]){
                    ways[adjnode] = (ways[adjnode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
        }
    }
