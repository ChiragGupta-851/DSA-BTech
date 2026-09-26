class Solution {
     static class Tuple {
        int row, col, tm;
        Tuple(int _row, int _col, int _tm) {
            this.row = _row;
            this.col = _col;
            this.tm = _tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        Queue<Tuple> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = 2; 
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        int cnt = 0; 
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.tm;
            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                    vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    
                    q.add(new Tuple(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2; 
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return tm;
    }
}