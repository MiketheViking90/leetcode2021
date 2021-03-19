package algo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    Map<InOut, List<Integer>> inOutTimes;
    Map<Integer, NameTime> idToStationMap;

    public UndergroundSystem() {
        inOutTimes = new HashMap<>();
        idToStationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToStationMap.put(id, new NameTime(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        NameTime nt = idToStationMap.get(id);
        String inName = nt.station;

        InOut io = new InOut(inName, stationName);
        List<Integer> curTimes = inOutTimes.getOrDefault(io, new ArrayList<>());
        int duration = t - nt.time;
        curTimes.add(duration);

        inOutTimes.put(io, curTimes);
    }

    public double getAverageTime(String startStation, String endStation) {
        InOut io = new InOut(startStation, endStation);
        List<Integer> times = inOutTimes.get(io);
        if (times == null) {
            return 0.0;
        }
        return times.stream().mapToDouble(a -> a).average().orElse(0.0);
    }

    @EqualsAndHashCode
    @ToString
    class InOut {
        public InOut(String in, String out) {
            this.in = in;
            this.out = out;
        }

        String in;
        String out;
    }

    @EqualsAndHashCode
    @ToString
    class NameTime {
        public NameTime(String station, int time) {
            this.station = station;
            this.time = time;
        }

        String station;
        int time;
    }

    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        us.checkOut(45, "Waterloo", 15);
        us.checkOut(27, "Waterloo", 20);
        us.checkOut(32, "Cambridge", 22);
        double avg = us.getAverageTime("Paradise", "Cambridge");
        System.out.println(avg);
    }
}
