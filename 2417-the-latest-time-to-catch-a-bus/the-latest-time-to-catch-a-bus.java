// Intuition:
// 1. Simulate boarding each bus in order, allowing passengers who arrive on time.
// 2. Find the latest time you could arrive and still board the last bus without taking someone else's spot.

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);       // Sort buses by departure time
        Arrays.sort(passengers);  // Sort passengers by arrival time

        int pIndex = 0;           // Pointer to the current passenger
        int filledSeats = 0;      // Tracks seats filled on the current bus

        // Simulate boarding process for each bus
        for (int i = 0; i < buses.length; i++) {
            filledSeats = 0;

            // Board passengers who arrive on or before the bus time, until capacity is reached
            while (pIndex < passengers.length &&
                   passengers[pIndex] <= buses[i] &&
                   filledSeats < capacity) {
                filledSeats++;
                pIndex++;
            }
        }

        // Move pointer to the last boarded passenger
        pIndex--;

        // Case: Last bus has room and its exact time isn't taken by a passenger
        if (filledSeats < capacity &&
            (pIndex < 0 || passengers[pIndex] != buses[buses.length - 1])) {
            return buses[buses.length - 1];
        }

        // Case: Last bus is full or time is taken — find the latest unoccupied time
        while (pIndex > 0 && passengers[pIndex] - 1 == passengers[pIndex - 1]) {
            pIndex--;
        }

        return passengers[pIndex] - 1;
    }
}
