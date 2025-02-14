class Solution {
    public double angleClock(int hour, int minutes) {
       
        if (hour == 12) hour = 0;

        double hourHand = (hour * 30) + (minutes * 0.5);

        double minutesHand = minutes * 6;

        double angle = Math.abs(hourHand - minutesHand);

        return Math.min(angle, 360 - angle);
    }
}
