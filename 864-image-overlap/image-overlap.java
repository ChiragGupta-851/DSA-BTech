class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) list1.add(r * 100 + c);
                if (img2[r][c] == 1) list2.add(r * 100 + c);
            }
        }
        Map<Integer, Integer> counts = new HashMap<>();
        int maxOverlap = 0;
        
        for (int i : list1) {
            for (int j : list2) {
                int diff = i - j; 
                counts.put(diff, counts.getOrDefault(diff, 0) + 1);
                maxOverlap = Math.max(maxOverlap, counts.get(diff));
            }
        }
        
        return maxOverlap;
    }
}