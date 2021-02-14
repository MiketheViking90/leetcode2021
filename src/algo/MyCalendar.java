package algo;

import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> intervals;

    public MyCalendar() {
        intervals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (intervals.isEmpty()) {
            intervals.put(start, end);
            return true;
        }

        Integer floorKey = intervals.floorKey(start);
        Integer ceilingKey = intervals.ceilingKey(start);

        boolean isFloorAvailable = floorKey == null || intervals.get(floorKey) <= start;
        boolean isCeilingAvailable = ceilingKey == null || intervals.get(ceilingKey) > end;

        return isFloorAvailable && isCeilingAvailable;
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        mc.book(12, 24);
    }
}
