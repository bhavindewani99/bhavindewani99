class SparseVector {
    int[] nums1;
    SparseVector(int[] nums) {
        this.nums1 = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(int i=0;i<nums1.length;i++){
            res += nums1[i]*vec.nums1[i];
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);