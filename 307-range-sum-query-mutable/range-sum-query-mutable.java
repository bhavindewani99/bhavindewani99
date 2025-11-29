class NumArray {

    int[] segment;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        segment = new int[4 * n];
        constructTree(0, 0, n - 1, nums);
    }
    
    public void update(int index, int val) {
        int currentVal = sumRange(index, index);
        int diff = val - currentVal;
        update(0, 0, n - 1, diff, index);
    }
    
    public int sumRange(int left, int right) {
        return getSum(0, 0, n - 1, left, right);
    }

    private int constructTree(int segIndex, int low, int high, int[] nums) {
        if (low == high) {
            segment[segIndex] = nums[low];
            return segment[segIndex];
        }
        int mid = (low + high) / 2;
        
        int left = constructTree(2 * segIndex + 1, low, mid, nums);
        int right = constructTree(2 * segIndex + 2, mid + 1, high, nums);
        
        segment[segIndex] = left + right;
        return segment[segIndex];
    }

    private void update(int segIndex, int low, int high, int diff, int index) {
        if (index < low || index > high) return;

        segment[segIndex] += diff;

        if (low == high) return;

        int mid = (low + high) / 2;
        update(2 * segIndex + 1, low, mid, diff, index);
        update(2 * segIndex + 2, mid + 1, high, diff, index);
    }

    private int getSum(int segIndex, int low, int high, int lowQ, int highQ) {

        if (lowQ <= low && high <= highQ) return segment[segIndex];

        if (high < lowQ || highQ < low) return 0;

        int mid = (low + high) / 2;

        int leftSum = getSum(2 * segIndex + 1, low, mid, lowQ, highQ);
        int rightSum = getSum(2 * segIndex + 2, mid + 1, high, lowQ, highQ);

        return leftSum + rightSum;
    }
}
