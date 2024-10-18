class Solution {
    public int minAreaRect(int[][] points) {

        int area = Integer.MAX_VALUE;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int n = points.length;
        for(int i=0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];
            if(map.containsKey(x)==false) map.put(x, new HashSet<>());
            map.get(x).add(y);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1!=x2 && y1!=y2){
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                        area = Math.min(area, Math.abs(y1-y2)*Math.abs(x1-x2));
                    }
                }
            }
        }
        return area==Integer.MAX_VALUE ? 0 : area;
    }
}