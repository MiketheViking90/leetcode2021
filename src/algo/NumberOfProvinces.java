package algo;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, int[][] adjList, Set<Integer> visited) {
        visited.add(node);
        int[] neighbors = adjList[node];
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == 1 && !visited.contains(i)) {
                dfs(i, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        int[][] adj = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int n = np.findCircleNum(adj);
        System.out.println(n);
    }
}
