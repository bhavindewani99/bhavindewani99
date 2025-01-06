class Solution {
    private static final int[][] DIR = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;

        int walls = 0;

        while(true){
            PriorityQueue<Region> pq = new PriorityQueue<>((a,b) -> b.uninfected.size() - a.uninfected.size());
            boolean[][] visited = new boolean[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(isInfected[i][j] != 1 || visited[i][j]) continue;

                    Region region = new Region();
                    dfs(i, j, region, isInfected, visited, new boolean[m][n],m,n);

                    if(region.uninfected.size()>0){
                        pq.offer(region);
                    }
                }
            }

            if(pq.isEmpty()) break;

            Region containRegion = pq.poll();
            walls += containRegion.wallsRequired;

            for(int[] cell : containRegion.infected){
                isInfected[cell[0]][cell[1]] = 2;
            }

            while(!pq.isEmpty()){
                Region spreading = pq.poll();
                for(int[] cell : spreading.uninfected){
                    isInfected[cell[0]][cell[1]] = 1;
                }
            }
        }

        return walls;
    }

    private void dfs(int i, int j, Region reg, int[][] grid, boolean[][] visited, boolean[][] uninfectedVis, int m, int n) {
        visited[i][j] = true;
        reg.addInfected(i, j);

        for(int[] dir : DIR) {
            int di = i + dir[0];
            int dj = j + dir[1];

            if( di < 0 || dj < 0 || di == m || dj == n || grid[di][dj] == 2 || visited[di][dj] )
                continue;

            if(grid[di][dj]==0){
                reg.wallsRequired++;
                if(!uninfectedVis[di][dj]){
                    uninfectedVis[di][dj] = true;
                    reg.addUnInfected(di, dj);
                }
            }else{
                dfs(di, dj, reg, grid, visited, uninfectedVis, m, n);
            }

        }
    }


    class Region{
        List<int[]> infected;
        List<int[]> uninfected;
        int wallsRequired;

        Region(){
            infected = new ArrayList<>();
            uninfected = new ArrayList<>();
        }

        void addInfected(int r, int c){
            infected.add(new int[]{r,c});
        }

        void addUnInfected(int r, int c){
            uninfected.add(new int[]{r,c});
        }
    }
}