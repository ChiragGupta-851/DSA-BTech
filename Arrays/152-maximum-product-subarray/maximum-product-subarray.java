class Solution {
    public int maxProduct(int[] nums) { //Kadane's Algorithm Modified
        int curmax = nums[0];
        int curmin = nums[0];
        int globalMax = nums[0];
         for (int i = 1; i < nums.length; i++) {
    

            if (nums[i] < 0) {
                int temp = curmax;
                curmax = curmin;
                curmin = temp;
            }

            
            
            int nextMax = nums[i];
            if (nums[i] * curmax > nextMax) {
                nextMax = nums[i] * curmax;
            }

            int nextMin = nums[i];
            if (nums[i] * curmin < nextMin) {
                nextMin = nums[i] * curmin;
            }

            curmax = nextMax;
            curmin = nextMin;

            if (curmax > globalMax) {
                globalMax = curmax;
            }
        }

        return globalMax;
        
    }
}