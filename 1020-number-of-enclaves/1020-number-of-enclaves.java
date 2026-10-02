class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid, n, m);
            }
            if (grid[n - 1][j] == 1) {
                dfs(n - 1, j, grid, n, m);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, n, m);
            }
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid, n, m);
            }
        }
        
        int enclaveCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    enclaveCount++;
                }
            }
        }
        
        return enclaveCount;
    }
    
    private void dfs(int r, int c, int[][] grid, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        
        dfs(r - 1, c, grid, n, m); 
        dfs(r + 1, c, grid, n, m); 
        dfs(r, c - 1, grid, n, m); 
        dfs(r, c + 1, grid, n, m); 
    }
        
    }
