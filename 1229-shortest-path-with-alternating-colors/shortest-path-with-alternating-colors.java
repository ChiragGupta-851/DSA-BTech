class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : redEdges) { 
            adj[edge[0]].add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            adj[edge[0]].add(new int[]{edge[1], 1});
        }
        
        // Initialize answer array with -1
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        
        boolean[][] visited = new boolean[n][2];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, -1});
        visited[0][0] = true;
        visited[0][1] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int steps = curr[1];
            int prevColor = curr[2];
            
            for (int[] neighbor : adj[node]) {
                int nextNode = neighbor[0];
                int edgeColor = neighbor[1];
                
                if (edgeColor != prevColor && !visited[nextNode][edgeColor]) {
                    visited[nextNode][edgeColor] = true;
                    
                    if (answer[nextNode] == -1) {
                        answer[nextNode] = steps + 1;
                    }
                    
                    queue.offer(new int[]{nextNode, steps + 1, edgeColor});
                }
            }
        }
        
        return answer;
    }
}