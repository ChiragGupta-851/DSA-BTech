class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        final int inf = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int j = 1; j <= n; ++j) {
            int stepCost = costs[j - 1]; 
            for (int i = Math.max(0, j - 3); i < j; ++i) {
                int jumpDistance = j - i;
                int formulaCost = stepCost + (jumpDistance * jumpDistance);
                
                dp[j] = Math.min(dp[j], dp[i] + formulaCost);
            }
        }
        
        return dp[n];
    }
}