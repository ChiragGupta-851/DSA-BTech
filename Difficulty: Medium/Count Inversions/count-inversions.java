class Solution {
     public static int mergeSort(int[] arr, int left, int right) {
        int cnt = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Accumulate counts from left half, right half, and merge step
            cnt += mergeSort(arr, left, mid);
            cnt += mergeSort(arr, mid + 1, right);
            cnt += merge(arr, left, mid, right);
        }
        return cnt;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int cnt = 0;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                // CRITICAL FIX: The number of inversions is the remaining 
                // elements in the left subarray, which is (n1 - i)
                cnt += (n1 - i);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        return cnt;
    }

    // Function to count inversions in the array.
    public int inversionCount(int arr[]) {
        // Return the final accumulated count
        return mergeSort(arr, 0, arr.length - 1);
    }
}