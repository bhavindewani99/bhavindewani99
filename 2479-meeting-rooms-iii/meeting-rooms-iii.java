class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time

        int[] roomMeetingCount = new int[n]; // Track how many meetings each room has

        // Min-heap for available rooms, ordered by room number
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Min-heap for ongoing meetings: (endTime, roomNumber)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Free up rooms whose meetings have ended
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            int duration = end - start;

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{start + duration, room});
                roomMeetingCount[room]++;
            } else {
                long[] nextAvailable = busyRooms.poll();
                long nextEnd = nextAvailable[0];
                int room = (int) nextAvailable[1];
                busyRooms.offer(new long[]{nextEnd + duration, room});
                roomMeetingCount[room]++;
            }
        }

        // Find the room with the most meetings (tie -> lowest room number)
        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomMeetingCount[i] > maxMeetings) {
                maxMeetings = roomMeetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
