class Solution {
    public int kthElement(int a[], int b[], int k) {
       
       if (a.length > b.length) {
           return kthElement(b, a, k); 
       }

       int m = a.length;
       int n = b.length;
       int low = Math.max(0, k - n);
       int high = Math.min(m, k);

       while (low <= high) {
           int partitionX = (low + high) / 2;
           int partitionY = k - partitionX;

           int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
           int minRightX = (partitionX == m) ? Integer.MAX_VALUE : a[partitionX];

           int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
           int minRightY = (partitionY == n) ? Integer.MAX_VALUE : b[partitionY];

           if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
               return Math.max(maxLeftX, maxLeftY);
           } 
           else if (maxLeftX > minRightY) {
               high = partitionX - 1;
           } 
           else {
               low = partitionX + 1;
           }
       }

       throw new IllegalArgumentException("Input parameters are invalid.");
}
}