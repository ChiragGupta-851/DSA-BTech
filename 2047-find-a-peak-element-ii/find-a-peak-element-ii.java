class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length - 1;
        
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            
            
            int maxRow = 0;
            for (int row = 0; row < mat.length; row++) {
                if (mat[row][midCol] > mat[maxRow][midCol]) {
                    maxRow = row;
                }
            }
            
           
            int leftNeighbor = (midCol - 1 >= startCol) ? mat[maxRow][midCol - 1] : -1;
            int rightNeighbor = (midCol + 1 <= endCol) ? mat[maxRow][midCol + 1] : -1;
        
            if (mat[maxRow][midCol] > leftNeighbor && mat[maxRow][midCol] > rightNeighbor) {
                return new int[]{maxRow, midCol}; 
            } else if (mat[maxRow][midCol] < leftNeighbor) {
                endCol = midCol - 1; 
            } else {
                startCol = midCol + 1; 
            }
        }
        
        return new int[]{-1, -1};
        
    }
}