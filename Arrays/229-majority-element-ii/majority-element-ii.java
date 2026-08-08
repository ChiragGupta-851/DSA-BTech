class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0; 
        int el1 = 0;
        int el2 = 0; //We will check two numbers here as in case of N/2, there can be only 1 possible number but in case of N/3, two numbers will be there
       for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (num == el1 && count1 > 0) {
                count1++;
            } else if (num == el2 && count2 > 0) {
                count2++;
            } else if (count1 == 0) {
                el1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                el2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        //  Verification Pass 
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            }
        }

        if(count1>(nums.length/3)) result.add(el1);
        if(count2>(nums.length/3) && el1!=el2) result.add(el2);
        return result;

         
    }
}