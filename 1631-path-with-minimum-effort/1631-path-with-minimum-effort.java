class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = 1_000_000; // Maximum possible height constraint from problem statement
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Test a prospective maximum effort 'mid'
            
            if (canReachDestination(heights, mid)) {
                ans = mid;
                high = mid - 1; // Try to look for a path with even less effort
            } else {
                low = mid + 1;  // 'mid' threshold is too tight; no valid path exists
            }
        }
        return ans;
    }
    
    // Private feasibility function using standard BFS/DFS instead of a linear loop
    private boolean canReachDestination(int[][] heights, int maxEffortAllowed) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        // Start BFS from top-left corner
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            // Success base case: We successfully reached the bottom-right corner
            if (r == rows - 1 && c == cols - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                // Boundary check and visited validation
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && !visited[nextR][nextC]) {
                    int currentEffort = Math.abs(heights[r][c] - heights[nextR][nextC]);
                    
                    // Accumulator Condition: We only step forward if the effort is within bounds
                    if (currentEffort <= maxEffortAllowed) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return false;
        
    }
}