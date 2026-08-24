class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1; 
        int high = 1;
        
        
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (sumofarr(nums, mid) <= threshold) {
                ans = mid;      
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        
        return ans;
    }
    
    private int sumofarr(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + x - 1) / x; 
        }
        return sum;
}
}