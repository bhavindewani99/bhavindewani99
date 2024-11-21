class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Sort tickets to ensure lexicographical order
        Collections.sort(tickets, (a, b) -> a.get(0).equals(b.get(0)) 
            ? a.get(1).compareTo(b.get(1)) 
            : a.get(0).compareTo(b.get(0)));

        // Step 2: Build graph
        Map<String, Deque<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new LinkedList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        // Step 3: Result list
        LinkedList<String> result = new LinkedList<>();

        // Step 4: Perform DFS to find Eulerian path
        dfs("JFK", map, result);

        return result;
    }

    private void dfs(String source, Map<String, Deque<String>> map, LinkedList<String> result) {
        Deque<String> destinations = map.getOrDefault(source, new LinkedList<>());
        while (!destinations.isEmpty()) {
            String next = destinations.pollFirst();
            dfs(next, map, result);
        }
        result.addFirst(source); // Add to the front to construct the path in reverse
    }
}
