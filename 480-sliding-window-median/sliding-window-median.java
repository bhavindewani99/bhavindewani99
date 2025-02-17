class Solution {
    TreeSet<Integer> lo, hi;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        lo = new TreeSet<>(
                (a, b) -> nums[a] != nums[b] ? Long.compare(nums[a], nums[b]) : a - b);
        hi = new TreeSet<>(
                (a, b) -> nums[a] != nums[b] ? Long.compare(nums[a], nums[b]) : a - b);
        int n = nums.length;
        

        double[] res = new double[n - k + 1];
        int ind = 0;
        
        for (int i = 0; i < n; i++) {
            if (lo.isEmpty() || nums[i] <= nums[lo.last()]) {
                lo.add(i);
            } else {
                hi.add(i);
            }

            balance();

            if (i >= k) {
                if (lo.contains(i - k)) {
                    lo.remove(i - k);
                } else {
                    hi.remove(i - k);
                }
                balance();
            }

            if (i >= k - 1) {
                if (k % 2 == 1){
                    res[ind] = (double)nums[lo.last()];
                }else{
                    res[ind] = ((double)nums[hi.first()] + (double)nums[lo.last()]) / 2.0;
                }
                ind++; 
            }
        }
        return res;
    }
    
    public void balance() {
        if (lo.size() > hi.size() + 1) {
            hi.add(lo.pollLast());
        }
        if (hi.size() > lo.size()) {
            lo.add(hi.pollFirst());
        }
    }
}