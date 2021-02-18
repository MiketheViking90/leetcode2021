package algo;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> stubs = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String des = ticket.get(1);

            List<String> curStub = stubs.getOrDefault(src, new ArrayList<>());
            curStub.add(des);
            Collections.sort(curStub);
            stubs.put(src, curStub);
        }


        List<String> itin = new ArrayList<>();
        dfs("JFK", itin, stubs);
        return itin;
    }

    private void dfs(String airport, List<String> itin, Map<String, List<String>> stubs) {
        itin.add(airport);
        List<String> destinations = stubs.get(airport);

        for (String des : destinations) {
            dfs(des, itin, stubs);
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> itin = new ArrayList<>();
        itin.add(List.of("JFK", "SFO"));
        itin.add(List.of("JFK", "ATL"));
        itin.add(List.of("SFO", "ATL"));
        itin.add(List.of("ATL", "JFK"));
        itin.add(List.of("ATL", "SFO"));

        List<String> trip = ri.findItinerary(itin);
        System.out.println(trip);
    }
}
