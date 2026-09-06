class Solution {
    public int trailingZeroes(int n) {
          if (n < 0) return 0;
        
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5; 
            n /= 5;
        }
        
        return cnt;
    }
}