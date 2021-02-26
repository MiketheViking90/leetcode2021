package algo;

import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int beg = interval[0];
            int end = interval[1];

            if (!reuseRoom(rooms, beg, end)) {
                rooms.add(end);
            }
        }
        return rooms.size();
    }

    private boolean reuseRoom(PriorityQueue<Integer> rooms, int beg, int end) {
        for (int i = 0; i < rooms.size(); i++) {
            int roomEnd = rooms.peek();
            if (beg >= roomEnd) {
                rooms.poll();
                rooms.offer(end);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MeetingRoomsII mr = new MeetingRoomsII();
        int[][] intervals = {{1, 5}, {8, 9}, {8,9}};
        int rooms = mr.minMeetingRooms(intervals);
        System.out.println(rooms);
    }
}
