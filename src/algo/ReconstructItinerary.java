package algo;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String des = ticket.get(1);

            List<String> outgoing = flights.getOrDefault(src, new LinkedList<>());
            outgoing.add(des);
            Collections.sort(outgoing);
            flights.put(src, outgoing);
        }

        List<String> itinerary = new ArrayList<>();
        traverse(itinerary, flights, "JFK");
        return  itinerary;
    }

    private void traverse(List<String> itinerary, Map<String, List<String>> flights, String airport) {
        itinerary.add(airport);
        if (flights.isEmpty()) {
            return;
        }
        if (!flights.containsKey(airport)) {
            return;
        }

        List<String> dests = flights.get(airport);
        while(!dests.isEmpty()) {
            String next = dests.get(0);
            dests.remove(0);
            flights.remove(airport);
            traverse(itinerary, flights, next);
        }
    }


    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> itin = new ArrayList<>();
        itin.add(List.of("JFK", "KUL"));
        itin.add(List.of("JFK", "NRT"));
        itin.add(List.of("NRT", "JFK"));

        List<String> trip = ri.findItinerary(itin);
        System.out.println(trip);
    }
}
