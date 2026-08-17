class Solution {
    // Merges two sorted halves
    private void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    // Counts reverse pairs where nums[i] > 2 * nums[j]
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            // Cast to long to avoid overflow when multiplying by 2
            while (right <= high && (long) nums[i] > 2 * (long) nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    // Recursive Merge Sort function
    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high) return count;

        int mid = low + (high - low) / 2; // Prevent overflow
        
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
