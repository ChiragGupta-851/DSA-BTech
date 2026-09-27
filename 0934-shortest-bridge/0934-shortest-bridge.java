class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean foundFirstIsland = false;
        for (int r = 0; r < n; r++) {
            if (foundFirstIsland) break;
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dfsMarkAndQueue(grid, r, c, n, queue);
                    foundFirstIsland = true; 
                    break;
                }
            }
        }
        
        int bridgesFlipped = 0;
        
        while (!queue.isEmpty()) {
            int currentLayerSize = queue.size();
           
            for (int i = 0; i < currentLayerSize; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return bridgesFlipped;
                        } else if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            bridgesFlipped++;
        }
        
        return bridgesFlipped;
    }
    
    private void dfsMarkAndQueue(int[][] grid, int r, int c, int n, Queue<int[]> queue) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }
        
        grid[r][c] = 2; 
        queue.offer(new int[]{r, c}); 
        
        for (int[] dir : directions) {
            dfsMarkAndQueue(grid, r + dir[0], c + dir[1], n, queue);
        }
    }
    }
