class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<>();
        
     
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        
        
        int left = 0, right = n - 1;   // right tracks columns (n)
        int top = 0, bottom = m - 1;   // bottom tracks rows (m)

        while (top <= bottom && left <= right) { 
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; 

           
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; 

            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; 
            }
        }
        
        return ans;
    }
}