import java.util.*;

public class MobileTelegraphs1806 {
    static int[] costs = new int[10];
    static int n;
    static List<Integer> result = new ArrayList<>();
    static Map<Long, Integer> names = new HashMap<>();

    static class Point {
        long name;
        Point parent;
        int distance;
        boolean done;
        int index;

        public Point(int i) {
            distance = Integer.MAX_VALUE;
            done = false;
            index = i;
        }
    }

    static Map<Point, Integer> neighbor = new HashMap<>();
    static List<Point> point = new ArrayList<>();

    static void calDiff(Point pointNow) {
        neighbor.clear();
        long name = pointNow.name;
        long temp;
        for (int i = 0; i < 10; i++) {
            temp = name - name % (long) Math.pow(10, i + 1) / (long) Math.pow(10, i) * (long) Math.pow(10, i) - (long) Math.pow(10, i);
            for (int j = 0; j < 10; j++) {
                temp += (long) Math.pow(10, i);
                if (temp == name) continue;
                if (names.containsKey(temp)) neighbor.put(point.get(names.get(temp)), costs[9 - i]);
            }
        }
        for (int i = 0; i < 10; i++) {
            int a = (int) (name % (long) Math.pow(10, i + 1) / (long) Math.pow(10, i));
            for (int j = i + 1; j < 10; j++) {
                int b = (int) (name % (long) Math.pow(10, j + 1) / (long) Math.pow(10, j));
                temp = name + (long) Math.pow(10, i) * (b - a) + (long) Math.pow(10, j) * (a - b);
                if (names.containsKey(temp)) neighbor.put(point.get(names.get(temp)), costs[9 - j]);
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Map.Entry<Integer, Point>> queue = new PriorityQueue<>(Map.Entry.comparingByKey());
        point.get(0).distance = 0;
        queue.offer(new AbstractMap.SimpleEntry<>(0, point.get(0)));

        Point now;
        while (!queue.isEmpty()) {
            now = queue.poll().getValue();
            if (now.index == n) return;
            if (now.done) continue;
            calDiff(now);
            now.done = true;
            for (Map.Entry<Point, Integer> entry : neighbor.entrySet()) {
                Point n = entry.getKey();
                int cost = entry.getValue();
                if (!n.done && n.distance > now.distance + cost) {
                    n.parent = now;
                    n.distance = now.distance + cost;
                    queue.offer(new AbstractMap.SimpleEntry<>(n.distance, n));
                }
            }
        }
    }

    static void chaseBack() {
        result.add(n);
        Point pointTemp = point.get(n - 1).parent;
        while (pointTemp != point.get(0)) {
            result.add(0, pointTemp.index);
            pointTemp = pointTemp.parent;
        }
        result.add(0, 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        for (int i = 0; i < 10; i++) {
            costs[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            point.add(new Point(i + 1));
            point.get(i).name = in.nextLong();
            names.put(point.get(i).name, i);
        }

        dijkstra();

        if (point.get(n - 1).distance >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            chaseBack();
            System.out.println(point.get(n - 1).distance);
            System.out.println(result.size());
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }
}