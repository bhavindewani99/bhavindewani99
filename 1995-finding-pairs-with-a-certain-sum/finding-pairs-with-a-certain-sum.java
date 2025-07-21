class FindSumPairs {

    Map<Integer, Integer> map = new HashMap<>();
    int[] nums1, nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i : nums2) this.map.put(i, this.map.getOrDefault(i, 0) + 1);
    }
    
    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index])-1);
        if(map.get(nums2[index])==0) map.remove(nums2[index]);
        map.put(nums2[index]+val, map.getOrDefault(nums2[index]+val, 0) + 1);
        nums2[index] += val;
    }
    
    public int count(int tot) {
        int result = 0;
        for(int ele : nums1){
            int remain = tot - ele;
            result += map.getOrDefault(remain, 0);
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */