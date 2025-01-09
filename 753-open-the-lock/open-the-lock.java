class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String s : deadends) set.add(s);

        if (set.contains("0000")) return -1; 
        if ("0000".equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.offer("0000");
        seen.add("0000");
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currPattern = queue.poll();

                if (currPattern.equals(target)) return steps;

                for (int j = 0; j < 4; j++) {
                    char[] currPatternArray = currPattern.toCharArray();

                    currPatternArray[j] = (char) (((currPatternArray[j] - '0') + 1) % 10 + '0');
                    String forward = String.valueOf(currPatternArray);
                    if (!set.contains(forward) && seen.add(forward)) {
                        queue.offer(forward);
                    }

                    currPatternArray[j] = (char) (((currPatternArray[j] - '0') - 2 + 10) % 10 + '0');
                    String backward = String.valueOf(currPatternArray);
                    if (!set.contains(backward) && seen.add(backward)) {
                        queue.offer(backward);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
