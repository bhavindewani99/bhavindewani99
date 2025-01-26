class Solution {
    public long numberOfSubsequences(int[] nums) {
        
        // convert from p*r == q**s to  p/q == s/r 
        // Count number of pairs where p/q == s/r
        long result = 0;
        int n = nums.length;
        Map<String, Integer> count = new HashMap<>();

        for(int r = 4;r<n-2;r++){
            int q = r-2;
            for(int p=0;p<=q-2;p++){
                int gcd = findGcd(nums[p], nums[q]);
                String key = (nums[p]/gcd) + "-" + (nums[q]/gcd);
                count.put(key, count.getOrDefault(key, 0) + 1);
            }

            for(int s=r+2;s<n;s++){
                int gcd = findGcd(nums[s], nums[r]);
                String key = (nums[s]/gcd) + "-" + (nums[r]/gcd);
                result += count.getOrDefault(key, 0);
            }
        }

        return result;
    }

    private int findGcd(int a, int b){
        if(a==0) return b;
        return findGcd(b%a, a);
    }
}