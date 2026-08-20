class UndergroundSystem {
    private Map<Integer,CheckInInfo> infomap;
    private Map<String,RouteInfo> route;

    public UndergroundSystem() {
        infomap = new HashMap<>();
        route = new HashMap<>();
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        infomap.put(id,new CheckInInfo(stationName , t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo k = infomap.remove(id);
        String rkey = k.stationName +"to"+stationName;
        int traveltime= t-k.time;
        RouteInfo routee = route.getOrDefault(rkey, new RouteInfo(0.0, 0));
        routee.totalTime += traveltime;
        routee.tripCount +=1;
        route.put(rkey,routee);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routkey = startStation + "to" + endStation;
        RouteInfo j = route.get(routkey);
        return j.totalTime/j.tripCount;
    }
    class CheckInInfo {
    String stationName;
    int time;

    public CheckInInfo(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}
private static class RouteInfo {
        double totalTime;
        int tripCount;

        public RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}



/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */