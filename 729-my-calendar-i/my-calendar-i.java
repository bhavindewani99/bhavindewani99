import java.util.*;

class MyCalendar {
    private final List<int[]> events = new ArrayList<>();

    public boolean book(int start, int end) {
        int lo = 0, hi = events.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (events.get(mid)[0] < start) lo = mid + 1;
            else hi = mid;
        }
        // lo is the insertion index
        if (lo - 1 >= 0 && events.get(lo - 1)[1] > start) return false;
        if (lo < events.size() && end > events.get(lo)[0]) return false;

        events.add(lo, new int[]{start, end});
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */