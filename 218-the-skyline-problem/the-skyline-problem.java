class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // we are splitting input into 2 parts as starting point and end point and to differentiate between the we are keeping start point as negative and end point as positive

        int n = buildings.length;
        int[][] points = new int[2*n][2];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            points[2*i] = new int[] {buildings[i][0] , -buildings[i][2]};
            points[2*i+1] = new int[] {buildings[i][1] , buildings[i][2]};
        }

        Arrays.sort(points, (a,b) -> a[0]==b[0] ? a[1] - b[1] : a[0]-b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,1);

        int currHeight = 0;

        for(int[] point : points){
            int coordinate = point[0];
            int height = point[1];

            if(height<0){ // means starting position
                map.put(-height, map.getOrDefault(-height, 0) + 1);
            }else{
                map.put(height, map.get(height)-  1);
                if(map.get(height)==0) map.remove(height);
            }
            if(currHeight!=map.lastKey()){
                result.add(new ArrayList<>(Arrays.asList(coordinate, map.lastKey())));
                currHeight = map.lastKey();
            }
        }

        return result;
    }
}