class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       long n = grid.length;
        long totalElements = n * n; 
        
      
        long SN = (totalElements * (totalElements + 1)) / 2; //Sum from 1 to n
        long S2N = (totalElements * (totalElements + 1) * (2 * totalElements + 1)) / 6; //Sum of squares from 1 to n 
        
        long sum = 0;
        long sum2 = 0;
        
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                sum += val;
                sum2 += val * val;
            }
        }
     
        long val1 = sum - SN;    // X - Y (Repeated - Missing)
        long val2 = sum2 - S2N;  // X^2 - Y^2
        
        val2 = val2 / val1;      // X + Y
        
        long x = (val1 + val2) / 2; 
        long y = x - val1;         
        
        return new int[]{(int)x, (int)y};

    }
}