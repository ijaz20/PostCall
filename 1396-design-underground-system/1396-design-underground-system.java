class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> idMap = null;
    Map<String, Pair<Integer, Integer>> avg = null;
    public UndergroundSystem() {
        idMap = new HashMap<>();
        avg = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> res = idMap.get(id);
        String dist = res.getKey() + "-" + stationName;
        int time = t - res.getValue();
        if(avg.containsKey(dist)){
            Pair<Integer, Integer> exist = avg.get(dist);
            avg.put(dist, new Pair<>(exist.getKey() + time, exist.getValue() + 1));
        } else {
            avg.put(dist, new Pair<>(time, 1));
        }        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> pair = avg.get(startStation +"-" + endStation);
        // System.out.println(pair.getKey() + " " + pair.getValue());
        return (double)(pair.getKey() * 1.0 / pair.getValue());
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */