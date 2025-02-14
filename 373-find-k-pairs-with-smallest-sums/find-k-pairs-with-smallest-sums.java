class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Set<String> set = new HashSet<>();
        pq.offer(new int[]{0,0,nums1[0] + nums2[0]});

        while(k>0){
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];
            String seen = i+"-"+j;
            if(set.contains(seen)) continue;
            set.add(seen);
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            result.add(list);
            k--;
            if(i+1<nums1.length) pq.offer(new int[]{i+1, j, nums1[i+1] + nums2[j]});
            if(j+1<nums2.length) pq.offer(new int[]{i, j+1, nums1[i] + nums2[j+1]});
            if(i+1<nums1.length && j+1 < nums2.length) pq.offer(new int[]{i+1, j+1, nums1[i+1] + nums2[j+1]});
        }
        return result;
    }
}