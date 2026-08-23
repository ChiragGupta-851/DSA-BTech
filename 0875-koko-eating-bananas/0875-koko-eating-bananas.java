class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHours = 0;
            
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            
            if (totalHours <= h) {
                res = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        
        return res;
        
    }
}