class Solution {
    public int primePalindrome(int n) {
       while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            
            n++;
            
            
            if (n > 11_000_000 && n < 100_000_000) {
                n = 100_000_001; 
            }
        }
    } 

    private boolean isPalindrome(int x) { // Check Palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = (reversedNum * 10) + (x % 10);
            x /= 10;
        }
        return x == reversedNum || x == reversedNum / 10;
    } 
        
    private boolean isPrime(int x) { // Check Prime
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false; 
        
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    } 
}
