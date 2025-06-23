class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = 0;
        int maxValue = arr[0];


        for(int i=1;i<arr.length;i++){
            oneDelete = Math.max(noDelete, oneDelete + arr[i]);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            maxValue = Math.max(maxValue, Math.max(oneDelete, noDelete));
        }

        return maxValue;
    }
}