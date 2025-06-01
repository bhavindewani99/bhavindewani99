class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int length1 = nums1.length, length2 = nums2.length;
        Map<Integer, List<Integer>> map = new HashMap<>(); // Element to indexes
        int[][] dp = new int[length1][length2];

        for(int[] temp : dp) Arrays.fill(temp, -1);
        for(int i=0;i<nums1.length;i++){
            map.putIfAbsent(nums1[i], new ArrayList<>());
            map.get(nums1[i]).add(i);
        }

        return recursion(0, 0, length1, length2, nums1, nums2, map, dp);

    }

    private int recursion(int index1, int index2, int length1, int length2, int[] nums1, int[] nums2, Map<Integer, List<Integer>> map, int[][] dp){
        if(index1 >= length1 || index2 >= length2) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];

        int not_take1 = recursion(index1+1, index2, length1, length2, nums1, nums2, map, dp);
        int not_take2 = recursion(index1, index2+1, length1, length2, nums1, nums2, map, dp);
        int take = 0;

        if(map.containsKey(nums2[index2])){
            for(int nextIndex : map.get(nums2[index2])){
                if(nextIndex >= index1){
                    take = 1 + recursion(nextIndex+1, index2+1, length1, length2, nums1, nums2, map, dp);
                    break;
                }
            }
        }
        return dp[index1][index2] = Math.max(take, Math.max(not_take1, not_take2));
    }


}