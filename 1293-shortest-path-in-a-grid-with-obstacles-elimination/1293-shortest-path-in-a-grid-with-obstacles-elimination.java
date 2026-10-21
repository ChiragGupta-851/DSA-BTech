class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (k >= m + n - 2) { //min steps: (m-1) + (n-1)
            return m + n - 2;
        }
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, k, 0});
        visited[0][0][k] = true;
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int remK = current[2];
            int steps = current[3];
            
            if (r == m - 1 && c == n - 1) {
                return steps;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == 0 && !visited[nr][nc][remK]) {
                        visited[nr][nc][remK] = true;
                        queue.offer(new int[]{nr, nc, remK, steps + 1});
                    }
                    else if (grid[nr][nc] == 1 && remK > 0 && !visited[nr][nc][remK - 1]) {
                        visited[nr][nc][remK - 1] = true;
                        queue.offer(new int[]{nr, nc, remK - 1, steps + 1});
                    }
                }
            }
        }
        
        return -1; 
    }
}