class Solution {
    public int rowWithMax1s(int[][] arr) { //Pointer Approach has better T.C. of O(m+n)
         int n = arr.length;
        int m = arr[0].length;
        
        int row = 0;
        int col = m - 1;
        int maxRowIdx = -1; 

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                maxRowIdx = row; 
                col--; 
            } else {
                row++; 
            }
        }

        return maxRowIdx;
        
    }
}