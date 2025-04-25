class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] aParts = a.split(":");
                String[] bParts = b.split(":");

                int aMinutes = Integer.parseInt(aParts[0]) * 60 + Integer.parseInt(aParts[1]);
                int bMinutes = Integer.parseInt(bParts[0]) * 60 + Integer.parseInt(bParts[1]);

                return aMinutes - bMinutes;
            }
        });

        int minDiff = Integer.MAX_VALUE;
        int firstTime = getMinutes(timePoints.get(0));
        int prevTime = firstTime;

        for (int i = 1; i < timePoints.size(); i++) {
            int currTime = getMinutes(timePoints.get(i));
            minDiff = Math.min(minDiff, currTime - prevTime);
            prevTime = currTime;
        }

        // Wrap-around difference (between last and first)
        int lastTime = getMinutes(timePoints.get(timePoints.size() - 1));
        minDiff = Math.min(minDiff, 1440 - lastTime + firstTime);

        return minDiff;
    }

    private int getMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
