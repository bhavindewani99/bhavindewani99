class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2]; // [value, original index]

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort based on digit sum, break ties by value
        Arrays.sort(arr, (a, b) -> {
            int sumA = getSum(a[0]);
            int sumB = getSum(b[0]);
            if (sumA == sumB) return a[0] - b[0];
            return sumA - sumB;
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // already visited or already in correct place
            if (visited[i] || arr[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1]; // move to the original index
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    public int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
