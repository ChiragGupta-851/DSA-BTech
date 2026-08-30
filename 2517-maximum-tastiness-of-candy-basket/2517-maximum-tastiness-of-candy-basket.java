class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        
        int low = 0;
        int high = price[price.length - 1] - price[0];
        int ans = 0;
        
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
           
            if (canFormBasket(price, k, mid)) {
                ans = mid;     
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }

    private boolean canFormBasket(int[] price, int k, int targetDiff) {
        
        int count = 1; 
        int lastPickedPrice = price[0];
        
        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastPickedPrice >= targetDiff) {
                count++;
                lastPickedPrice = price[i]; 
            }
            if (count >= k) {
                return true;
            }
        }
        
        return false;
        
    }
}