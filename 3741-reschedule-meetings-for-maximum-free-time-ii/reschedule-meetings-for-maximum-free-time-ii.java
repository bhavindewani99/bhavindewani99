class Solution {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length + 1;
        int[] extendedStart = Arrays.copyOf(startTime, n);
        int[] extendedEnd = Arrays.copyOf(endTime, n);
        extendedStart[n - 1] = eventTime;
        extendedEnd[n - 1] = eventTime;

        List<Pair> top3 = new ArrayList<>();
        top3.add(new Pair(extendedStart[0] - 0, 0));
        top3.add(new Pair(-1, -1));
        top3.add(new Pair(-1, -1));

        for (int i = 1; i < n; i++) {
            int gap = extendedStart[i] - extendedEnd[i - 1];
            if (gap > top3.get(2).first) {
                top3.set(2, new Pair(gap, i));
                top3.sort((a, b) -> b.first - a.first); // descending order
            }
        }

        int maxFreeTime = 0;
        for (int i = 0; i < n - 1; i++) {
            int freeTime = getFreeTimeByRescheduling(i, top3, extendedStart, extendedEnd);
            maxFreeTime = Math.max(maxFreeTime, freeTime);
        }

        return maxFreeTime;
    }

    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int getFreeTimeByRescheduling(int i, List<Pair> top3, int[] startTime, int[] endTime) {
        int lastEnd = (i == 0) ? 0 : endTime[i - 1];
        int meetingDuration = endTime[i] - startTime[i];
        int nextStart = startTime[i + 1];
        int originalGap = nextStart - lastEnd;

        for (Pair gap : top3) {
            if (gap.first >= meetingDuration && gap.second != i && gap.second != i + 1) {
                return originalGap;
            }
        }

        return originalGap - meetingDuration;
    }

    
}
