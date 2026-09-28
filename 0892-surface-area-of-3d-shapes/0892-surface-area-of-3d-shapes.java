class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];

                if (height > 0) {
                    totalArea += 6 * height;
                    totalArea -= 2 * (height - 1);
                    if (j + 1 < n) {
                        totalArea -= 2 * Math.min(height, grid[i][j + 1]);
                    }
                    if (i + 1 < n) {
                        totalArea -= 2 * Math.min(height, grid[i + 1][j]);
                    }
                }
            }
        }

        return totalArea;
    }
}