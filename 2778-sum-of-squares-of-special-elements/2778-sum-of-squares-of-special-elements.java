class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        boolean special = false;
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                special = true;
                sum += nums[i-1]*nums[i-1];
            }
        }
        return sum;
    }
}