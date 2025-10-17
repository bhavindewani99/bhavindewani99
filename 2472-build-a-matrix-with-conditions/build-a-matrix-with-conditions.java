import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Graphs and degree arrays
        List<List<Integer>> rowgraph = new ArrayList<>(), colgraph = new ArrayList<>();
        int[] rowdegree = new int[k + 1], coldegree = new int[k + 1];

        // Build graphs and get topological order for both
        List<Integer> rowpath = buildGraph(rowConditions, rowgraph, rowdegree, k);
        List<Integer> colpath = buildGraph(colConditions, colgraph, coldegree, k);

        // If invalid topological sort (cycle detected)
        if (rowpath.size() < k || colpath.size() < k) return new int[0][0];

        int[][] result = new int[k][k];
        Map<Integer, Integer> rowPosition = new HashMap<>();

        // Map each number to its row index
        for (int i = 0; i < k; i++) {
            rowPosition.put(rowpath.get(i), i);
        }

        // Place each element based on its row and column topological position
        for (int i = 0; i < k; i++) {
            int element = colpath.get(i);
            int row = rowPosition.get(element);
            result[row][i] = element;
        }

        return result;
    }

    private List<Integer> buildGraph(int[][] matrix, List<List<Integer>> graph, int[] degree, int k) {
        // Initialize adjacency list
        for (int i = 0; i <= k; i++) graph.add(new ArrayList<>());

        // Build graph and in-degree
        for (int[] mat : matrix) {
            int u = mat[0], v = mat[1];
            graph.get(u).add(v);
            degree[v]++;
        }

        // Kahn’s algorithm
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (degree[i] == 0) bfs.add(i);
        }

        List<Integer> path = new ArrayList<>();
        while (!bfs.isEmpty()) {
            int node = bfs.poll();
            path.add(node);

            for (int nei : graph.get(node)) {
                degree[nei]--;
                if (degree[nei] == 0) bfs.add(nei);
            }
        }

        return path;
    }
}
