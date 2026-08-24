class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minCap = Integer.MAX_VALUE;
        int bestIndex = -1;

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < minCap) {
                minCap = capacity[i];
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}