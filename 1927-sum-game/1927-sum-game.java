class Solution {
    public boolean sumGame(String num) {
        int  n = num.length();
        int leftsum = 0;
        int rightsum = 0;
        int cleft = 0;
        int cright = 0;
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cleft++;
            } else {
                leftsum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                cright++;
            } else {
                rightsum += c - '0';
            }
        }

        int sumDiff = leftsum - rightsum;
        int countDiff = cright - cleft;

       
        return sumDiff * 2 != countDiff * 9;
        
    }
}