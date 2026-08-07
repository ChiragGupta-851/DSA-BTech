class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int temp = n;
            int digitProduct = 1;
            
            if (temp == 0) {
                digitProduct = 0;
            }
            
            while (temp > 0) {
                int digit = temp % 10;
                digitProduct *= digit;
                temp /= 10;
            }
            
            if (digitProduct % t == 0) {
                return n;
            }
            
            n++;
        }
        
    }
}