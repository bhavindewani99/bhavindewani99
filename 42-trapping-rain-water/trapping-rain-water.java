class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int water = 0;
        int lwall = 0;
        int rwall = 0;

        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>lwall){
                    lwall = height[l];
                }else{
                    water += lwall-height[l];
                }
                l++;
            }else{
                if(height[r]>rwall){
                    rwall=height[r];
                }else{
                    water += rwall-height[r];
                }
                r--;
            }
        }
        return water;
    }
}