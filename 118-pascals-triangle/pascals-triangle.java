class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<>();
         for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }
        
        return ans;
    }

    // Striver's O(N) row generation shortcut 
    private List<Integer> generateRow(int row) {
        List<Integer> currentRow = new ArrayList<>();
        
        // Element at column 1 is always 1
        long ansElement = 1; 
        currentRow.add((int) ansElement);
        
        // Generate the remaining elements of the row
        for (int col = 1; col < row; col++) {
            // Formula: current_element = previous_element * (row - col) / col
            ansElement = ansElement * (row - col);
            ansElement = ansElement / col;
            
            currentRow.add((int) ansElement);
        }
        return currentRow;

        
    }
}