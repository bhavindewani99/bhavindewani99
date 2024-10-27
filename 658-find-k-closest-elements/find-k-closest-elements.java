class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int index = findIndex(arr, x);
        int l = index-1;
        int r = index;
        int z = k;
        while(k>0){
            if(l<0){
                r++;
            }else if(r>=n){
                l--;
            }
            else if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)){
                l--;
            }else{
                r++;
            }
            k--;
        }
        for(int i=l+1;i<=l+z;i++){
            res.add(arr[i]);
        }
        return res;
    }

    private int findIndex(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int res = arr.length;
        while(low<=high){
            int mid = (low+high)>>1;
            //if(arr[mid]==x) return mid;
            if(arr[mid]>=x){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
}