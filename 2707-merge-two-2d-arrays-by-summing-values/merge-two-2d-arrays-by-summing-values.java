class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i =0, j= 0;
        List<int[]> list = new ArrayList<>();

        while(i<nums1.length && j<nums2.length){
            int[] curr = {0,0};
            if(nums1[i][0] == nums2[j][0]){
                curr = nums1[i];
                curr[1] = nums1[i++][1] + nums2[j++][1];
            }else if(nums1[i][0] < nums2[j][0]){
                curr = nums1[i++];
            }else{
                curr = nums2[j++];
            }
            list.add(curr);
        }
        while (i<nums1.length) { list.add(nums1[i++]); }
        while(j<nums2.length) { list.add(nums2[j++]); }

        int[][] result = new int[list.size()][2];

        for(i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }
}