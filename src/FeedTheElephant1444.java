//FeedTheElephant
import java.util.*;
public class FeedTheElephant1444 {
    static class Point {
        int x, y, i;

        Point(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

    static Point[] p = new Point[30000];

    static int f(Point a, Point b) {
        if (a.x*b.y == a.y*b.x && a.x*b.x + a.y*b.y >= 0)
            return Integer.compare(a.x*a.x + a.y*a.y, b.x*b.x + b.y*b.y);
        return Double.compare(Math.atan2(a.y, a.x), Math.atan2(b.y, b.x));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            p[i] = new Point(x, y, i);
        }

        for (int i = n-1; i >= 0; i--) {
            p[i].x -= p[0].x;
            p[i].y -= p[0].y;
        }

        Arrays.sort(p, 1, n, FeedTheElephant1444::f);

        int s = 0;
        for (int i = 0; i < n-1; i++) {
            Point p0 = p[0], p1 = p[i+1], p2 = p[(i+2) % n];
            int d1x = p1.x-p0.x, d2y = p2.y-p0.y, d1y = p1.y-p0.y, d2x = p2.x-p0.x;
            int x = d1x*d2y - d1y*d2x, d = d1x*d2x + d1y*d2y;
            if (x < 0 || x == 0 && d < 0) {
                s = i+1;
                break;
            }
        }

        System.out.println(n);
        System.out.println(p[0].i+1);
        for (int i = 0; i < n-1; i++) {
            int index = (s+i) % (n-1) + 1;
            System.out.println(p[index].i+1);
        }
    }
}