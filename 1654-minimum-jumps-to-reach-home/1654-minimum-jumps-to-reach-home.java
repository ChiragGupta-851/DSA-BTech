class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
         Set<Integer> forbiddenSet = new HashSet<>();
        int maxForbidden = 0;
        for (int pos : forbidden) {
            forbiddenSet.add(pos);
            maxForbidden = Math.max(maxForbidden, pos);
        }
        int maxLimit = Math.max(maxForbidden, x) + a + b;

        boolean[][] visited = new boolean[maxLimit + 1][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int pos = curr[0];
                int backCount = curr[1];

                if (pos == x) {
                    return steps;
                }

                int forwardPos = pos + a;
                if (forwardPos <= maxLimit && !forbiddenSet.contains(forwardPos) && !visited[forwardPos][0]) {
                    visited[forwardPos][0] = true;
                    queue.offer(new int[]{forwardPos, 0}); 
                }

                if (backCount == 0) {
                    int backwardPos = pos - b;
                    if (backwardPos >= 0 && !forbiddenSet.contains(backwardPos) && !visited[backwardPos][1]) {
                        visited[backwardPos][1] = true;
                        queue.offer(new int[]{backwardPos, 1}); 
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}