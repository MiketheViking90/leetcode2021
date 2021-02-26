package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> closest = new PriorityQueue<>(
                Comparator.comparingDouble(this::getEuclidianDist).reversed()
        );

        for (int[] point : points) {
            if (closest.size() < K) {
                closest.offer(point);
            } else {
                int[] peek = closest.peek();
                double pointDist = getEuclidianDist(point);
                assert peek != null;
                double peekDist = getEuclidianDist(peek);
                if (pointDist < peekDist) {
                    closest.poll();
                    closest.offer(point);
                }
            }
        }

        int[][] pointsArray = new int[K][2];
        for (int i = 0; i < K; i++) {
            pointsArray[i] = closest.poll();
        }
        return pointsArray;
    }

    private double getEuclidianDist(int[] point) {
        int x = point[0];
        int y = point[1];

        return Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        KClosestPointsToOrigin kc = new KClosestPointsToOrigin();
        int[][] close = kc.kClosest(points, 2);
        System.out.println(Arrays.deepToString(close));

        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
            System.out.println(kc.getEuclidianDist(point));
        }
    }
}
