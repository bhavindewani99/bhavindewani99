class Solution {
    public int[][] constructGridLayout(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        buildGraph(graph, n, edges, degree);

        List<Integer> firstRow = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int rootNode = getMinimumNode(degree);
        visited[rootNode] = true;
        firstRow.add(rootNode);

        for(int i=0;i<firstRow.size();i++){
            if(firstRow.size() >=2 && degree[firstRow.get(0)] == degree[firstRow.get(firstRow.size()-1)]) break;

            for(int nei : graph.get(firstRow.get(i))){
                if(visited[nei]==false){
                    visited[nei] = true;
                    firstRow.add(nei);
                    break;
                }
            }
        }

        
        int cols = firstRow.size();
        int rows = n / cols;
        int[][] result = new int[rows][cols];

        for(int row = 0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(row==0){
                    result[row][col] = firstRow.get(col);
                    continue;
                }
                int neiNode = result[row-1][col];
                for(int neis : graph.get(neiNode)){
                    if(visited[neis]==false){
                        visited[neis]=true;
                        result[row][col]=neis;
                        break;
                    }
                }
            }
        }
        return result;

    }

    private void buildGraph(List<List<Integer>> graph, int n, int[][] edges, int[] degree){

        for(int node=0;node<n;node++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        for(int node=0;node<n;node++){
            Collections.sort(graph.get(node), (a,b) -> degree[a]-degree[b]);
        }
    }

    private int getMinimumNode(int[] degree){
        int minValue = Integer.MAX_VALUE;
        int node = -1;

        for(int i=0;i<degree.length;i++){
            if(minValue > degree[i]){
                minValue = degree[i];
                node = i;
            }
        }
        return node;
    }
}

