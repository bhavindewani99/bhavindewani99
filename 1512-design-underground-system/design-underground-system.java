class UndergroundSystem {
    Map<Integer, Station> logs;
    Map<String, Station> averages;
    public UndergroundSystem() {
        logs = new HashMap<>();
        averages = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Station station = new Station();
        station.time = t;
        station.stationName = stationName;
        logs.put(id, station);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Station station = logs.get(id);
        station.sum += (t-station.time);
        station.n++;
        String key = station.stationName + "#" + stationName;
        if(averages.containsKey(key)){
            Station newObject = averages.get(key);
            newObject.sum += station.sum;
            newObject.n += station.n;
            return;
        }
        averages.put(key, station);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        Station station = averages.get(key);
        return station.sum/station.n;
    }
}

class Station{
    double n, sum;
    int time;
    String stationName;
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */