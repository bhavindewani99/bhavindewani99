class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powers = new ArrayList<>();
        int[] result = new int[queries.length];
        long mod = (int) 1e9 + 7;

        // Step 1: Extract powers of 2 from binary representation of n
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                powers.add((long) Math.pow(2, i));
            }
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long product = 1;

            // Compute the product in range [l, r]
            for (int j = l; j <= r; j++) {
                product = (product * powers.get(j)) % mod;
            }

            result[i] = (int) product;
        }

        return result;
    }
}
