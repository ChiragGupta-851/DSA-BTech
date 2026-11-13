class Solution {
    public int minCostConnectPoints(int[][] points) { //Prim's Algorithm
        int n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] inMST = new boolean[n];
        
        int totalCost = 0;
        int visitedCount = 0;

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty() && visitedCount < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            int weight = curr[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            totalCost += weight;
            visitedCount++;

            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) 
                             + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{v, dist});
                }
            }
        }

        return totalCost;
    }
}