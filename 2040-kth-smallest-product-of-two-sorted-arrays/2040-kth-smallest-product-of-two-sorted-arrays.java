class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countPairsLessThanOrEqual(nums1, nums2, mid) >= k) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    private long countPairsLessThanOrEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;

        for (int x : nums1) {
            if (x > 0) {
                
                count += countElementsLessOrEqual(nums2, mid, x);
            } else if (x < 0) {
                count += countElementsGreaterOrEqual(nums2, mid, x);
            } else {
                if (mid >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
    private int countElementsLessOrEqual(int[] nums2, long mid, int x) {
        int l = 0, r = nums2.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) x * nums2[m] <= mid) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans + 1;
    }

    private int countElementsGreaterOrEqual(int[] nums2, long mid, int x) {
        int l = 0, r = nums2.length - 1;
        int ans = nums2.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) x * nums2[m] <= mid) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums2.length - ans;
    }
}