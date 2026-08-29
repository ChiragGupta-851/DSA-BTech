class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) { int maxRowIdx = 0;
        int maxOnes = 0;

        
        for (int i = 0; i < mat.length; i++) {
            int currentOnes = 0;
            
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    currentOnes++;
                }
            }

            if (currentOnes > maxOnes) {
                maxOnes = currentOnes;
                maxRowIdx = i;
            }
        }

        return new int[]{maxRowIdx, maxOnes};
    }
}