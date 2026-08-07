class Solution {
    
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        int n = nums.length;
        k = k % n; // Handle cases where d >= n
        reverse(nums, 0, n-k - 1);
        reverse(nums, n-k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[nums.length - 1 - (nums.length - 1 - end)] = temp; // Explicit swap using temp
            nums[end] = temp;
            start++;
            end--;
        }
        

        
    }
}