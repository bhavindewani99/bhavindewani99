class Solution {
    public int[] replaceElements(int[] arr) {
        
        int[] result = new int[arr.length];
        int greatest = -1;

        for(int i=arr.length-1;i>=0;i--){
            result[i] = greatest;
            greatest = Math.max(greatest, arr[i]);
        }
        return result;
    }
}