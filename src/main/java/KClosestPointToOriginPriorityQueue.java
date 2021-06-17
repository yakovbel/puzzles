import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointToOriginPriorityQueue {

    public int[][] kClosest(int[][] points, int k) {

        if(k == points.length) return points;

        int[][] result = kthPercentile(points, k);
        return result;
    }


    public int[][] kthPercentile(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(k, (p1,p2) -> -(len2(p1) - len2(p2)));
        for(int[] p : points) {
            q.add(p);
            if(q.size() > k) {
                q.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!q.isEmpty()) {
            result[i++] = q.poll();
        }
        return result;
    }


    public static int len2(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
