class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        
       
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        int ans = high;
        
   
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(nums, mid, maxOperations)) {
                ans = mid;         
                high = mid - 1;    
            } else {
                low = mid + 1;   
            }
        }
        
        return ans;
    }
    
    private boolean isPossible(int[] nums, int maxBagSize, int maxOperations) {
        int requiredOperations = 0;
        
        for (int num : nums) {
           
            requiredOperations += (num - 1) / maxBagSize;
            if (requiredOperations > maxOperations) {
                return false;
            }
        }
        
        return true;
        
    }
}