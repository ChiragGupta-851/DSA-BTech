class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; 

        // 8 possible directions for movement (horizontal, vertical, and diagonal)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        // Standard BFS Loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int length = current[2];

            if (r == n - 1 && c == n - 1) {
                return length;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; 
                    queue.offer(new int[]{nr, nc, length + 1});
                }
            }
        }

        return -1;
    }
}