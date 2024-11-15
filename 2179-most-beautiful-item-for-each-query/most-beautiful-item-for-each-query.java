class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                //if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });

        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        int[] result = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int index = binarySearch(items, queries[i]);
            result[i] = index==-1 ? 0 : items[index][1];
        }

        return result;
    }

    private int binarySearch(int[][] items, int price){
        int ans = -1;
        int low = 0;
        int high = items.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(items[mid][0]<=price){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}