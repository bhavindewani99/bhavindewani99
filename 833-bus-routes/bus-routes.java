class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map each stop to the list of routes (bus indices) that go through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {
                int stop = q.poll();

                for (int bus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) continue;

                    visitedBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busesTaken;
                        if (visitedStops.add(nextStop)) {
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
