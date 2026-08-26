class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;
        
        int low = 1;
        int high = 10_000_000; // Problem constraint max speed
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            
            if (canReachOnTime(dist, hour, mid)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    
    private boolean canReachOnTime(int[] dist, double maxHoursAllowed, int speed) {
        double totalHoursNeeded = 0.0;
        int n = dist.length;
        
       
        for (int i = 0; i < n - 1; i++) {
            totalHoursNeeded += (dist[i] + speed - 1) / speed;
        }
        
        totalHoursNeeded += (double) dist[n - 1] / speed;
        return totalHoursNeeded <= maxHoursAllowed;
    }
}