class Solution {
    public int minTime(int[] arr, int k) {
        int low = 0;
            int high = 0;

            for (int el : arr) {
                low = Math.max(low, el); 
                high += el;             
            }

            int ans = high;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (isPossible(arr, mid, k)) {
                    ans = mid;         
                    high = mid - 1;    
                } else {
                    low = mid + 1;    
                }
            }
            return ans;
        }

        private static boolean isPossible(int[] arr, int maxTime, int totalPainters) {
            int painterCount = 1;
            int currentLength = 0;

            for (int el : arr) {
                if (currentLength + el <= maxTime) {
                    currentLength += el;
                } else {
                    painterCount++;
                    currentLength = el;

                    // If painters required exceed available painters, it's not possible
                    if (painterCount > totalPainters) {
                        return false;
                    }
                }
            }
            return true;
    }
}
