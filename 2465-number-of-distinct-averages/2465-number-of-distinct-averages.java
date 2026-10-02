class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> uniqueSums = new HashSet<>();
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            uniqueSums.add(sum);
            left++;
            right--;
        }
        
        return uniqueSums.size();
    }
}