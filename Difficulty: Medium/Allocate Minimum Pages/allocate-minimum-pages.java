class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
            
        }
        long low = 0;
        long high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages; 
            
        }
        long result = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                result = mid;      
                high = mid - 1;
                
            } 
            else {
                low = mid + 1;      
            }
            
        }
        return (int)result;
            }

          
            private boolean isValid(int[] arr, int k, long maxPages) {
                int studentsRequired = 1;
                long currentPagesSum = 0;

                for (int pages : arr) {
                    if (currentPagesSum + pages > maxPages) {
                        studentsRequired++;
                        currentPagesSum = pages; 

                        if (studentsRequired > k) {
                            return false;
                        }
                    } else {
                        currentPagesSum += pages;
                    }
                }
                return true;
            }
        }
    