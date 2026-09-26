class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][][] vis = new boolean[n][n][2];
        
        q.add(new int[]{0, 0, 0, 0});
        vis[0][0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dir = curr[2];
            int moves = curr[3];
            
            if (r == n - 1 && c == n - 2 && dir == 0) {
                return moves;
            }
            
           
            if (dir == 0) {
               if (c + 2 < n && grid[r][c + 2] == 0) {
                    if (!vis[r][c + 1][0]) {
                        vis[r][c + 1][0] = true;
                        q.add(new int[]{r, c + 1, 0, moves + 1});
                    }
                }
                if (r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0) {
                    if (!vis[r + 1][c][0]) {
                        vis[r + 1][c][0] = true;
                        q.add(new int[]{r + 1, c, 0, moves + 1});
                    }
                    if (!vis[r][c][1]) {
                        vis[r][c][1] = true;
                        q.add(new int[]{r, c, 1, moves + 1});
                    }
                }
            } 
           
            else {
                if (r + 2 < n && grid[r + 2][c] == 0) {
                    if (!vis[r + 1][c][1]) {
                        vis[r + 1][c][1] = true;
                        q.add(new int[]{r + 1, c, 1, moves + 1});
                    }
                }
                if (c + 1 < n && grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0) {
                    if (!vis[r][c + 1][1]) {
                        vis[r][c + 1][1] = true;
                        q.add(new int[]{r, c + 1, 1, moves + 1});
                    }
                    if (!vis[r][c][0]) {
                        vis[r][c][0] = true;
                        q.add(new int[]{r, c, 0, moves + 1});
                    }
                }
            }
        }
        return -1;
    }
}