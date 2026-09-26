class Solution {
    public int bestRotation(int[] nums) {
         int n = nums.length;
        int[] change = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            int leftBoundary = (i - nums[i] + 1 + n) % n;
            int rightBoundary = (i + 1) % n;
            
            change[leftBoundary]--;
            
            change[0]++; 
            change[rightBoundary]++;
        }
        
        int maxScore = -1;
        int bestK = 0;
        int currentScore = 0;
        for (int k = 0; k < n; k++) {
            currentScore += change[k];
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }
        
        return bestK;
    }
}