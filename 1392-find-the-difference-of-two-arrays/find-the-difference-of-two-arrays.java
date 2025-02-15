class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i);

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for(int i:set1) {
            if(!set2.contains(i)) temp1.add(i);
        }

        for(int i : set2){
            if(!set1.contains(i)) temp2.add(i);
        }

        result.add(temp1);
        result.add(temp2);

        return result;
    }
}