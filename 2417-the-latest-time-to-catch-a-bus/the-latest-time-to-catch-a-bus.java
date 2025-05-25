class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int passengersIndex = 0;
        int currCapacity = 0;

        for(int i=0;i<buses.length;i++){
            currCapacity = 0;
            while (currCapacity < capacity && passengersIndex < passengers.length && buses[i] >= passengers[passengersIndex]) {
                currCapacity++;
                passengersIndex++;
            }
        }
        passengersIndex--;

        if(currCapacity < capacity && (passengersIndex < 0 || buses[buses.length-1] != passengers[passengersIndex])){
            return buses[buses.length-1];
        }
        
        while(passengersIndex > 0 && passengers[passengersIndex] -1  == passengers[passengersIndex-1]) passengersIndex--;

        return passengers[passengersIndex] - 1;
        
    }
}