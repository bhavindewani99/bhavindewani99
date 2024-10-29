class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i:nums1){
            map1.put(i, map1.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            map2.put(i, map2.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            int key = entry.getKey();
            if(map2.containsKey(key)){
                for(int k =0;k<Math.min(entry.getValue(),map2.get(key));k++){
                    ans.add(key);
                }
            }
        }

        int[] res = new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i] = ans.get(i);
        }
        return res;

    }
}