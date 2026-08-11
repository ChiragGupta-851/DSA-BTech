class Solution {
    public int maximumDifference(int[] nums) {
        int min_value = nums[0];
        int max_diff = -1;
        int diff = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<min_value){
                min_value = nums[i];
            }
            else if(nums[i]>min_value){
                diff = nums[i] - min_value;
                max_diff = Math.max(max_diff,diff);
            }
        }
        return max_diff;
        
    }
}