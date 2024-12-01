class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;

        for(int i=0;i<n;i++){
            int x = nums[i];
            int newLower = lower - x;
            int newUpper = upper -x;
            //if(newLower<0) continue;

            int l = lowerBound(nums, newLower, i+1);
            int r = upperBound(nums, newUpper, i+1);
            if(l==-1 || r==-1 || l>r) continue;
            System.out.println("Values is "+ x + " lower is " + newLower+ " upeer is " + newUpper + " l is " +l+ " r is " + r);
            ans += (r-l+1);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int val, int index){
        int ans = -1;
        int l =index;
        int r = nums.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]>=val){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int val, int index){
        int ans = -1;
        int l =index;
        int r = nums.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]<=val){
                ans = mid;
                l = mid+1;
            }else{
                 r = mid-1;
            }
        }
        return ans;
    }
}