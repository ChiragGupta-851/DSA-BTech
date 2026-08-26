class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for (int q : quantities) {
            high = Math.max(high, q);
        }
        
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(quantities, n, mid)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }
    
    private boolean canDistribute(int[] quantities, int totalStores, int maxPerStore) {
        int storesNeeded = 0;
        for (int q : quantities) {
            storesNeeded += (q + maxPerStore - 1) / maxPerStore;
        }
        return storesNeeded <= totalStores;
        
    }
}