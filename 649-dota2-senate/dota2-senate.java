import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                // R acts first, bans this D, R goes to next round
                r.add(ri + n);
            } else {
                d.add(di + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
