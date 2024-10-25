class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = heights.length;
        int[] views;
        res.add(n-1);

        for(int i=n-2;i>=0;i--){
            if(heights[i]>heights[res.get(res.size()-1)]){
                res.add(i);
            }
        }
        views = new int[res.size()];
        int index=0;

        for(int i=res.size()-1;i>=0;i--){
            views[index++] = res.get(i);
        }

        return views;
    }
}