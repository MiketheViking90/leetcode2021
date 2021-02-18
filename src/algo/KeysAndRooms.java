package algo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        Set<Integer> visited = new HashSet<>();

        return dfs(rooms, visited, 0, N);
    }

    private boolean dfs(List<List<Integer>> rooms, Set<Integer> visited, int room, int count) {
        visited.add(room);
        if (visited.size() == count) {
            return true;
        }
        List<Integer> keys = rooms.get(room);
        if (visited.containsAll(keys)) {
            return false;
        }

        boolean canVisit = false;
        for (int key : keys) {
            if (!visited.contains(key)) {
                if (dfs(rooms, visited, key, count)) {
                    canVisit = true;
                }
            }
        }
        return canVisit;
    }
}
