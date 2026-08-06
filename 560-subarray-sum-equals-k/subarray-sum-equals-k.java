class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap();
        h.put(0,1);
        int c = 0;
        int currentsum = 0;
        for(int i =0;i<nums.length;i++){
            currentsum = currentsum + nums[i];
            int rem = currentsum - k;
            if(h.containsKey(rem)){
                c = c+h.get(rem);
            }
            h.put(currentsum,h.getOrDefault(currentsum,0)+1);

        }
        return c;
        
    }
}