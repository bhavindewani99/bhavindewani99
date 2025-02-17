class Solution {
    public int magnificentSets(int n, int[][] edges) {

        Map<Integer , List<Integer>> adj=new HashMap<>();
        int visited[]=new int[n+1];
        Arrays.fill(visited, -1);
        for(int edge[]:edges){
            adj.computeIfAbsent(edge[0] , k->new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1] , k->new ArrayList<>()).add(edge[0]);
        }

        for(int i=1;i<=n;i++){
            if(visited[i]==-1){
                if( !isBiPartite(adj, i, visited, 0))
                return -1;
            }
        }

        int level[]=new int[n+1];
       
        for(int i=1;i<=n;i++){
            level[i]=bfs(adj , i , n);
        }

        boolean vi[]=new boolean[n+1];
        int maxSum=0;
        for(int i=1;i<=n;i++){
            if(!vi[i]){
                maxSum+=getMax(adj , i , vi , level);
            }
        }
        return maxSum;
    }

    public int getMax( Map<Integer , List<Integer>>  adj , int u , boolean vi[] ,int []level ){
        int max=level[u];
        vi[u]=true;
        for(int v:adj.getOrDefault(u , new ArrayList<>())){
            if(!vi[v]){
                max=Math.max(max , getMax(adj , v, vi, level));
            }
        }
        return max;

    }

    public int bfs( Map<Integer ,List<Integer>>  adj, int u, int n){
        boolean visited[]=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(u);
        int level=0;
        visited[u]=true;
        while(!q.isEmpty()){

          int size=q.size(); 
           level++;
           while(size>0){
                u=q.poll();
            
                for(int v:adj.getOrDefault(u , new ArrayList<>())){
                    if(visited[v]){
                        continue;
                    }
                    q.add(v);
                    visited[v]=true;
                }
                size--;
            }
        
        }
        return level;

    }

    public boolean isBiPartite(  Map<Integer , List<Integer>>  adj ,int u , int[] visited, int color ){
        visited[u]=color;
        for(int v:adj.getOrDefault(u , new ArrayList<>())){
            if(visited[v]==visited[u]){
                return false;
            }
            if(visited[v]==-1){
                if(!isBiPartite(adj , v , visited , 1-color)){
                    return false;
                }
            }
        }
        return true;
    }

    
}