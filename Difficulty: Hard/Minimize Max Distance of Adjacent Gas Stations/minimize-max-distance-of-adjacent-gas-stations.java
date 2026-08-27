class Solution {
    public double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        double low = 0.0;
        double high = 0.0;
        
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
            
        }
        for (int iter = 0; iter < 100; iter++) {
            double mid = low + (high - low) / 2;
            if (isFeasible(stations, k, mid)) {
                high = mid;
                } else {
                    low = mid;
                    
                }
            
        }
        return high;
        }

        
        private static boolean isFeasible(int[] stations, int k, double d) {
            int stationsNeeded = 0;

            for (int i = 0; i < stations.length - 1; i++) {
                double gap = stations[i + 1] - stations[i];

             
                stationsNeeded += (int) (gap / d);
            }

           
            return stationsNeeded <= k;
        }
        
    }

