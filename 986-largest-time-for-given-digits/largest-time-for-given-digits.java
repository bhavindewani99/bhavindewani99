class Solution {
    int maxMinutes = -1; // Track maximum valid time in total minutes

    public String largestTimeFromDigits(int[] arr) {
        backtrack(0, arr, "", new boolean[4]);
        if (maxMinutes == -1) return "";
        
        // Format back into "HH:MM" with guaranteed leading zeros
        int hours = maxMinutes / 60;
        int minutes = maxMinutes % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    private void backtrack(int index, int[] arr, String curr, boolean[] used) {
        if (index == arr.length) { // Check depth using the correct index variable
            int hours = Integer.parseInt(curr.substring(0, 2));
            int minutes = Integer.parseInt(curr.substring(2, 4));
            
            if (hours <= 23 && minutes <= 59) {
                int totalMinutes = hours * 60 + minutes;
                maxMinutes = Math.max(maxMinutes, totalMinutes);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                // Fix: Pass index + 1 to properly advance the recursion depth
                backtrack(index + 1, arr, curr + arr[i], used);
                used[i] = false;
            }
        }
    }
}
