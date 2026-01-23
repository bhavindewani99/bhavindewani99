class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[] group = new int[n];
        Arrays.fill(group, -1);
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] dislike : dislikes){
            int u = dislike[0]-1, v = dislike[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            if(group[i]==-1){
                if(dfs(i,1,graph,group) == false) return false;
            }
        }
        return true;
    }

    private boolean dfs(int currPerson, int currGroup,List<List<Integer>> graph,int[] group){

        group[currPerson] = currGroup;
        for(int nei : graph.get(currPerson)){
            if(group[nei] == -1){
                if(!dfs(nei, 1-currGroup, graph, group)) return false;
            }else if(group[nei] == currGroup){
                return false;
            }
        }
        return true;
    }
}