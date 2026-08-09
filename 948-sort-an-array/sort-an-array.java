class Solution {
    public int[] sortArray(int[] nums) { // Merge Sort
        // Handle edge case for empty or single-element arrays
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        mergeSort(nums, 0, nums.length - 1);
        return nums; // Added missing return statement
    } // Closed sortArray method properly

    // Moved out of sortArray so it is a valid independent method
    private static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left and right halves
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            // Merge the sorted halves
            merge(nums, left, mid, right);
        }
    }

    // Merges two sorted subarrays
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Copy smaller elements into temp
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements of right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy temporary array back to original array
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}