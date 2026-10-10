class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        if (maxDiff == 0) return 0;
        int[] bucket = new int[maxDiff + 1];
        long totalDiffSum = 0;
        for (int diff : diffs) {
            bucket[diff]++;
            totalDiffSum += diff;
        }
        long k = (long) k1 + k2;
        if (totalDiffSum <= k) return 0;
        for (int d = maxDiff; d > 0; d--) {
            if (bucket[d] > 0) {
                long opsNeededForCurrentLevel = bucket[d];
                
                if (k >= opsNeededForCurrentLevel) {
                    k -= opsNeededForCurrentLevel;
                    bucket[d - 1] += bucket[d];
                    bucket[d] = 0;
                } else {
                    bucket[d - 1] += k;
                    bucket[d] -= k;
                    k = 0; 
                    break;
                }
            }
        }
        
        // Step 5: Calculate the final sum of squared differences
        long minSquaredSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (bucket[d] > 0) {
                minSquaredSum += (long) bucket[d] * d * d;
            }
        }
        
        return minSquaredSum;

    }
}