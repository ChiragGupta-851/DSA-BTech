class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; 
            } else {
                int lake = rains[i];
                ans[i] = -1;
                
                if (fullLakes.containsKey(lake)) {
                    int lastRainDay = fullLakes.get(lake);
                    
                    Integer sunnyDay = dryDays.higher(lastRainDay);
                    
                    if (sunnyDay == null || sunnyDay > i) {
                        return new int[0];
                    }
                    
                    ans[sunnyDay] = lake;
                    dryDays.remove(sunnyDay);
                }
                
                fullLakes.put(lake, i);
            }
        }
        
        return ans;
    }
}