class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int i =0;
        int j = points.length-1;
        while(i<j){
            int mid = partition(points, i, j);
            if(mid==k) break;
            if(mid<k) i=mid+1;
            else j =mid-1;
        }
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int i, int j){
        int[] pivot = points[j];
        int index = i;
        for(int low = i;low<=j;low++){
            if(value(points[low]) < value(pivot)){
                swap(points,low,index);
                index++;
            }
        }
        swap(points,index,j);
        return index;
    }

    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}