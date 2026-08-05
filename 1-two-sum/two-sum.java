import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map< Integer, Integer> map = new HashMap<>();
        
        // Loop through the array exactly once
        for (int i = 0; i <= nums.length-1; i++) {
            int complement = target - nums[i];
            
            // Check if the required matching number is already in our map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store the current number and its index for future lookups
            map.put(nums[i], i);
        }
        
        // This line satisfies Java's compiler but won't be reached if a solution exists
        throw new IllegalArgumentException("No two sum solution");
    }
}