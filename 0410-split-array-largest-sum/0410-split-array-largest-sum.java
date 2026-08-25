class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num); 
            high += num;              
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;        
                high = mid - 1;   
            } else {
                low = mid + 1;     
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int maxLimit, int k) {
        int subarrayCount = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxLimit) {
                currentSum += num;
            } else {
                subarrayCount++;
                currentSum = num;

                // If subarrays needed exceed k, this maxLimit is too small
                if (subarrayCount > k) {
                    return false;
                }
            }
        }
        return true;
        
    }
}