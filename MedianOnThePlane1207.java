import java.util.Scanner;

public class MedianOnThePlane1207 {
    static class Point {
        long x;
        long y;
        double angle;
        int id;
    }

    static final int MAX_N = 10001;
    static Point[] arr = new Point[MAX_N];

    static double PI = 3.14159265358979323846;

    static boolean compare(Point p1, Point p2) {
        return p1.angle < p2.angle;
    }

    static void sort(int left, int right) {
        int i = left;
        int j = right;

        Point x = arr[(left + right) / 2];

        while (i <= j) {
            while (compare(arr[i], x)) {
                i++;
            }
            while (compare(x, arr[j])) {
                j--;
            }

            if (i <= j) {
                Point temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (i < right) {
            sort(i, right);
        }
        if (left < j) {
            sort(left, j);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long min_x = (long) 1e10;
        int first = 0;

        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            if (a < min_x) {
                min_x = a;
                first = i;
            }

            arr[i] = new Point();
            arr[i].x = a;
            arr[i].y = b;
            arr[i].id = i;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i].id == first) {
                arr[i].angle = -1e10;
            } else if (arr[i].x == arr[first].x) {
                arr[i].angle = (arr[i].y > arr[first].y) ? 90 : -90;
            } else {
                arr[i].angle = Math.atan((double) (arr[i].y - arr[first].y) / (arr[i].x - arr[first].x)) * 180.0 / PI;
            }
        }

        sort(0, n - 1);

        System.out.println((first + 1) + " " + (arr[n / 2].id + 1));
    }
}
