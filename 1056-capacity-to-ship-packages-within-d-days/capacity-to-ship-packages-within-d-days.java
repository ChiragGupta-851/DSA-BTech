class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                result = mid;       
                high = mid - 1;
            } else {
                low = mid + 1;      
            }
        }

        return result;
    }
    
    private boolean canShip(int[] weights, int days, int maxCapacity) {
        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > maxCapacity) {
                requiredDays++;         
                currentLoad = weight;   
                
                if (requiredDays > days) {
                    return false;
                }
            } else {
                currentLoad += weight;  
            }
        }

        return true;
}
}