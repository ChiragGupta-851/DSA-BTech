class Solution {
    private final int[] delRow = {-1, 0, 1, 0};
    private final int[] delCol = {0, 1, 0, -1};

    private boolean dfs(int r, int c, int pr, int pc, int[][] vis, char[][] grid) {
        vis[r][c] = 1; 
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int adjRow = r + delRow[i];
            int adjCol = c + delCol[i];
            
            if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m && grid[adjRow][adjCol] == grid[r][c]) {
                if (vis[adjRow][adjCol] == 0) {
                    if (dfs(adjRow, adjCol, r, c, vis, grid)) return true; 
                } 
                else if (adjRow != pr || adjCol != pc) {
                    return true; 
                }
            }
        }
        return false; 
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        if (n == 0) return false;
        int m = grid[0].length;
        int[][] vis = new int[n][m]; 
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0) {
                    if (dfs(i, j, -1, -1, vis, grid)) return true; 
                }
            }
        }
        return false; 
    }
}