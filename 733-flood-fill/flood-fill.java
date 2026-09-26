class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if (iniColor == color) return image; 
        
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = image[i].clone();
        }
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        
        dfs(sr, sc, ans, image, color, iniColor, delRow, delCol);
        return ans;
    }
    
    private void dfs(int row, int col, int[][] ans, int[][] image, 
                     int newColor, int iniColor, int[] delRow, int[] delCol) {
        ans[row][col] = newColor;
        
        int n = image.length;
        int m = image[0].length;
        
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && 
                image[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, iniColor, delRow, delCol);
            }
        }
    }
}