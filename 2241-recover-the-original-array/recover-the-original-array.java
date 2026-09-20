class Solution {
    public int[] recoverArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            int gap = nums[i] - nums[0];
            if (gap == 0 || gap % 2 != 0) {
                continue;
            }
            
            int k = gap / 2;
            int[] ans = tryRecover(nums, k);
            
            if (ans != null) return ans;
        }
        
        return new int[0]; 
    }
    
    private int[] tryRecover(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n / 2];
        int idx = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            
            int lower = num;
            int higher = lower + 2 * k;
            if (freq.getOrDefault(higher, 0) == 0) {
                return null;
            }
            freq.put(lower, freq.get(lower) - 1);
            freq.put(higher, freq.get(higher) - 1);
            
            res[idx++] = lower + k;
        }
        
        return res;
    }
}