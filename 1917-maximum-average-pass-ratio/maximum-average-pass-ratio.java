class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain(), a.gain()) // max-heap by marginal gain
        );

        for (int[] clas : classes) pq.offer(new Pair(clas[0], clas[1]));

        while (extraStudents > 0) {
            Pair pair = pq.poll();
            pair.pass += 1;
            pair.total += 1;
            pq.offer(pair);
            extraStudents--;
        }

        double avgSum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            avgSum += (double) pair.pass / pair.total;
        }

        return avgSum / classes.length;
    }

    class Pair {
        int pass, total;
        Pair(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        double gain() {
            return (double)(pass + 1) / (total + 1) - (double) pass / total;
        }
    }
}
