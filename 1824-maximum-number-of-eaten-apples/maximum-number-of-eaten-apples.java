class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.exp - b.exp));
        int ans = 0;
        int i = 0;

        // Phase 1: During the days apples are produced
        for (; i < apples.length; i++) {
            if (apples[i] > 0) {
                pq.offer(new Pair(apples[i], i + days[i] - 1));
            }

            // Remove apples that are already rotten
            while (!pq.isEmpty() && pq.peek().exp < i) {
                pq.poll();
            }

            // Eat one apple from the batch expiring soonest
            if (!pq.isEmpty()) {
                ans++;
                Pair temp = pq.poll();
                if (--temp.app > 0) pq.offer(temp);
            }
        }

        // Phase 2: After production stops, keep eating stored apples
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().exp < i) {
                pq.poll();
            }
            if (pq.isEmpty()) break;

            Pair temp = pq.poll();
            // Eat as many as possible from this batch until they rot or we move to the next day
            int canEat = Math.min(temp.app, temp.exp - i + 1);
            ans += canEat;
            i += canEat;
        }
        return ans;
    }

    class Pair {
        int app, exp;
        Pair(int app, int exp) {
            this.app = app;
            this.exp = exp;
        }
    }
}
