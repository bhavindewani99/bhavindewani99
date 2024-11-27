class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length-1;

        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
            else if(arr[mid-1]>arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}