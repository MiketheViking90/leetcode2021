package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, TreeMap<Integer, String>> keyToValueHistory;

    /** Initialize your data structure here. */
    public TimeMap() {
        keyToValueHistory = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> valHistory = keyToValueHistory.getOrDefault(key, new TreeMap<>());
        valHistory.put(timestamp, value);
        keyToValueHistory.put(key, valHistory);
    }

    public String get(String key, int timestamp) {
        if (!keyToValueHistory.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> history = keyToValueHistory.get(key);
        Map.Entry<Integer, String> floorEntry = history.floorEntry(timestamp);
        if (floorEntry == null) {
            return "";
        }
        return floorEntry.getValue();
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("love", "high", 10);
        tm.set("love", "lo", 20);
        System.out.println(tm.get("love", 5));
        System.out.println(tm.get("love", 10));
        System.out.println(tm.get("love", 15));
        System.out.println(tm.get("love", 10));
    }
}