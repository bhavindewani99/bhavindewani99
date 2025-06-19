class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] hasBox = new boolean[status.length];
        boolean[] hasKey = new boolean[status.length];
        boolean[] opened = new boolean[status.length];
        int totalCandies = 0;

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                opened[box] = true;
            }
        }

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            for (int contained : containedBoxes[box]) {
                hasBox[contained] = true;
                if ((status[contained] == 1 || hasKey[contained]) && !opened[contained]) {
                    queue.offer(contained);
                    opened[contained] = true;
                }
            }

            for (int key : keys[box]) {
                hasKey[key] = true;
                if (hasBox[key] && !opened[key]) {
                    queue.offer(key);
                    opened[key] = true;
                }
            }
        }

        return totalCandies;
    }
}
