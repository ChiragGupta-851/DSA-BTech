class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIn = 0;
        int negIn = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negIn] = nums[i];
                negIn += 2;
            }
            else{
                ans[posIn] = nums[i];
                posIn += 2;
            }
        }
        return ans;
        
    }
}