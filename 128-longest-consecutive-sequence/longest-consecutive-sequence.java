class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> unordered = new HashSet<>();
        for(int i = 0;i<n;i++){
            unordered.add(nums[i]);
        }
        for(int s : unordered){
            if (!unordered.contains(s - 1)){
                int count = 1;
                int x = s;
                while(unordered.contains(x+1)){
                    x = x+1;
                    count = count+1;
                }
                longest = Math.max(longest,count);
               }
            }
            return longest;
        }
        
    }
