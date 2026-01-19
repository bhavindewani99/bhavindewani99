class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        
        // Pair: [cost, capacity]
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        // Sort by cost
        Arrays.sort(machines, (a, b) -> a[0] - b[0]);

        // Prefix max capacity
        int[] bestCap = new int[n];
        bestCap[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            bestCap[i] = Math.max(bestCap[i - 1], machines[i][1]);
        }

        int ans = 0;

        // Case 1: choose one machine
        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                ans = Math.max(ans, machines[i][1]);
            }
        }

        // Case 2: choose two machines
        for (int j = 1; j < n; j++) {
            int remaining = budget - machines[j][0];
            if (remaining <= 0) continue;

            int i = binarySearchLastValid(machines, j - 1, remaining);
            if (i >= 0) {
                ans = Math.max(ans, machines[j][1] + bestCap[i]);
            }
        }

        return ans;
    }

    private int binarySearchLastValid(int[][] machines, int right, int target) {
        int left = 0, res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (machines[mid][0] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}