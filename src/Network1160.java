import java.util.Scanner;

class Network1160 {
    static class Edge {
        int to, len;
        Edge next;

        Edge(int to, int len) {
            this.to = to;
            this.len = len;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Edge[] edg = new Edge[1010];
        Edge t;

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int l = scanner.nextInt();

            t = new Edge(b, l);
            t.next = edg[a];
            edg[a] = t;

            t = new Edge(a, l);
            t.next = edg[b];
            edg[b] = t;
        }

        int[] lc = new int[1010];
        int[] cls = new int[1010];
        int[] c1 = new int[1010];
        int[] c2 = new int[1010];

        lc[1] = 2000000000;
        for (int i = 2; i <= n; i++) {
            lc[i] = 1000000000;
            cls[i] = 1;
        }

        t = edg[1];
        while (t != null) {
            lc[t.to] = t.len;
            t = t.next;
        }

        int mv, mi, bv = -1;

        for (int i = 2; i <= n; i++) {
            mv = 2000000000;
            mi = -1;

            for (int j = 2; j <= n; j++) {
                if (lc[j] < mv) {
                    mv = lc[j];
                    mi = j;
                }
            }

            c1[i] = mi;
            c2[i] = cls[mi];

            if (mv > bv) {
                bv = mv;
            }

            lc[mi] = 2000000000;
            t = edg[mi];

            while (t != null) {
                if (lc[t.to] < 2000000000 && t.len < lc[t.to]) {
                    lc[t.to] = t.len;
                    cls[t.to] = mi;
                }
                t = t.next;
            }
        }

        System.out.println(bv);
        System.out.println(n - 1);

        for (int i = 2; i <= n; i++) {
            System.out.println(c1[i] + " " + c2[i]);
        }
    }
}
