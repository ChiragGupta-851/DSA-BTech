class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(busId);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        if (stopToBuses.containsKey(source)) {
            for (int busId : stopToBuses.get(source)) {
                queue.offer(busId);
                visitedBuses.add(busId);
            }
        }

        int busCount = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int currentBus = queue.poll();

                for (int stop : routes[currentBus]) {
                    if (stop == target) {
                        return busCount;
                    }

                    if (!visitedStops.contains(stop)) {
                        visitedStops.add(stop);
                        
                        if (stopToBuses.containsKey(stop)) {
                            for (int nextBus : stopToBuses.get(stop)) {
                                if (!visitedBuses.contains(nextBus)) {
                                    visitedBuses.add(nextBus);
                                    queue.offer(nextBus);
                                }
                            }
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}